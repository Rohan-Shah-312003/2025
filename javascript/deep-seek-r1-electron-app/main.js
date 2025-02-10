const { app, BrowserWindow, ipcMain } = require("electron")
const path = require("path")
const { spawn } = require("child_process")

let mainWindow
let deepseekProcess

function createWindow() {
  mainWindow = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
    },
  })

  mainWindow.loadFile("index.html")
}

app.whenReady().then(() => {
  createWindow()

  // Start the DeepSeek R1 process
  deepseekProcess = spawn("your-deepseek-r1-command", ["your", "arguments"])

  deepseekProcess.stdout.on("data", (data) => {
    mainWindow.webContents.send("model-output", data.toString())
  })

  deepseekProcess.stderr.on("data", (data) => {
    console.error(`DeepSeek R1 Error: ${data}`)
  })

  app.on("activate", () => {
    if (BrowserWindow.getAllWindows().length === 0) createWindow()
  })
})

app.on("window-all-closed", () => {
  if (process.platform !== "darwin") app.quit()
})

ipcMain.on("user-input", (event, input) => {
  if (deepseekProcess && deepseekProcess.stdin.writable) {
    deepseekProcess.stdin.write(input + "\n")
  }
})

