import java.util.Scanner;

public class Hanoi {
    // Stack implementation
    static class Stack {
        private int capacity;
        private int top;
        private int[] array;
        
        Stack(int capacity) {
            this.capacity = capacity;
            this.top = -1;
            this.array = new int[capacity];
        }
        
        boolean isFull() {
            return (top == capacity - 1);
        }
        
        boolean isEmpty() {
            return (top == -1);
        }
        
        void push(int item) {
            if (!isFull()) {
                array[++top] = item;
            }
        }
        
        int pop() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return array[top--];
        }
        
        // Added method to get current stack state
        String getState() {
            if (isEmpty()) {
                return "[]";
            }
            
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i <= top; i++) {
                sb.append(array[i]);
                if (i < top) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    // Move disk between two poles and print the state
    void moveDisksBetweenTwoPoles(Stack src, Stack dest, char s, char d, 
                                 Stack auxiliary, char a) {
        int pole1TopDisk = src.pop();
        int pole2TopDisk = dest.pop();
        
        // When pole 1 is empty
        if (pole1TopDisk == Integer.MIN_VALUE) {
            src.push(pole2TopDisk);
            System.out.println("\nMove disk " + pole2TopDisk + " from " + d + " to " + s);
        }
        // When pole 2 is empty
        else if (pole2TopDisk == Integer.MIN_VALUE) {
            dest.push(pole1TopDisk);
            System.out.println("\nMove disk " + pole1TopDisk + " from " + s + " to " + d);
        }
        // When top disk of pole1 > top disk of pole2
        else if (pole1TopDisk > pole2TopDisk) {
            src.push(pole1TopDisk);
            src.push(pole2TopDisk);
            System.out.println("\nMove disk " + pole2TopDisk + " from " + d + " to " + s);
        }
        // When top disk of pole1 < top disk of pole2
        else {
            dest.push(pole2TopDisk);
            dest.push(pole1TopDisk);
            System.out.println("\nMove disk " + pole1TopDisk + " from " + s + " to " + d);
        }
        
        // Print current state after each move
        printState(src, auxiliary, dest, s, a, d);
    }
    
    // Print current state of all towers
    void printState(Stack src, Stack auxiliary, Stack dest, char s, char a, char d) {
        System.out.println("Source (" + s + "): " + src.getState());
        System.out.println("Auxiliary (" + a + "): " + auxiliary.getState());
        System.out.println("Destination (" + d + "): " + dest.getState());
        System.out.println();
    }
    
    // Iterative TOH solution
    void tohIterative(int numOfDisks, Stack src, Stack auxiliary, Stack dest) {
        char s = 'S', d = 'D', a = 'A';
        
        // If number of disks is even, swap destination and auxiliary poles
        if (numOfDisks % 2 == 0) {
            char temp = d;
            d = a;
            a = temp;
        }
        
        int totalMoves = (int)(Math.pow(2, numOfDisks) - 1);
        
        // Initialize source pole
        for (int i = numOfDisks; i >= 1; i--) {
            src.push(i);
        }
        
        System.out.println("Initial state:");
        printState(src, auxiliary, dest, s, a, d);
        
        // Iterate through all moves
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDisksBetweenTwoPoles(src, dest, s, d, auxiliary, a);
            }
            else if (i % 3 == 2) {
                moveDisksBetweenTwoPoles(src, auxiliary, s, a, dest, d);
            }
            else if (i % 3 == 0) {
                moveDisksBetweenTwoPoles(auxiliary, dest, a, d, src, s);
            }
        }
        
        System.out.println("Final state:");
        printState(src, auxiliary, dest, s, a, d);
        System.out.println("Total moves: " + totalMoves);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int numOfDisks = sc.nextInt();
        
        if (numOfDisks <= 0) {
            System.out.println("Invalid number of disks");
            return;
        }
        
        System.out.println("\nSolving Tower of Hanoi for " + numOfDisks + " disks:");
        
        Hanoi tower = new Hanoi();
        
        // Create three stacks of size 'numOfDisks'
        Stack src = new Stack(numOfDisks);
        Stack dest = new Stack(numOfDisks);
        Stack auxiliary = new Stack(numOfDisks);
        
        tower.tohIterative(numOfDisks, src, auxiliary, dest);
        
        sc.close();
    }
}

// This code is contributed by Sumit Ghosh


//Enter number of disks: 2
//Initial state:
//Source (S): [2, 1]
//Auxiliary (A): []
//Destination (D): []
//
//Moves:
//Move disk 1 from S to A...
//Move disk 2 from S to D...
//Move disk 1 from A to D...
//
//Final state:
//Source (S): []
//Auxiliary (A): []
//Destination (D): [2, 1]
//
//
//Enter number of disks: 3
//The solution will show 7 moves (2³ - 1) to complete the puzzle.
//
//Enter number of disks: 0
//Invalid number of disks
