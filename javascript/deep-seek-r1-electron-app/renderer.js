const { ipcRenderer } = require("electron")

const outputDiv = document.getElementById("output")
const inputField = document.getElementById("input")

inputField.addEventListener("keypress", (event) => {
  if (event.key === "Enter") {
    const userInput = inputField.value
    ipcRenderer.send("user-input", userInput)
    appendToOutput("You: " + userInput)
    inputField.value = ""
  }
})

ipcRenderer.on("model-output", (event, output) => {
  appendToOutput("DeepSeek R1: " + output)
})

function appendToOutput(message) {
  const p = document.createElement("p")
  p.textContent = message
  outputDiv.appendChild(p)
  outputDiv.scrollTop = outputDiv.scrollHeight
}

