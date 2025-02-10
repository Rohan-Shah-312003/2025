import java.util.*;

public class LoopDetection {
    Node head;
    
    static class Node {
        int data;
        Node next;
        
        Node(int d) {
            this.data = d;
            next = null;
        }
    }
    
    void push(int n) {
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
    }
    
    // Returns true if loop exists and prints the loop start node
    boolean detectLoopHashing() {
        if (head == null) return false;
        
        HashSet<Node> visited = new HashSet<>();
        Node current = head;
        
        while (current != null) {
            if (visited.contains(current)) {
                System.out.println("Loop starts at node with data: " + current.data);
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        return false;
    }
    
    // Floyd's Cycle Detection Algorithm
    Node detectLoopFloyd() {
        if (head == null || head.next == null) return null;
        
        Node slow = head;
        Node fast = head;
        Node loopStart = null;
        
        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                // Find loop starting node
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                loopStart = slow;
                break;
            }
        }
        return loopStart;
    }
    
    // Print the linked list (stops if loop is detected)
    void printList() {
        HashSet<Node> visited = new HashSet<>();
        Node current = head;
        
        System.out.print("List: ");
        while (current != null && !visited.contains(current)) {
            System.out.print(current.data + " -> ");
            visited.add(current);
            current = current.next;
        }
        if (current != null) {
            System.out.print(current.data + " (loop starts here)");
        } else {
            System.out.print("null");
        }
        System.out.println();
    }
    
    // Create a loop at given position (0-based index)
    void createLoop(int position) {
        if (position < 0) return;
        
        Node current = head;
        Node loopNode = null;
        int count = 0;
        
        // Find the node at given position
        while (current.next != null && count < position) {
            current = current.next;
            count++;
            if (count == position) {
                loopNode = current;
            }
        }
        
        // Create loop by connecting last node to loop node
        while (current.next != null) {
            current = current.next;
        }
        current.next = loopNode;
    }
    
    public static void main(String[] args) {
        // Test Case 1: List with loop
        System.out.println("Test Case 1: List with loop");
        LoopDetection list1 = new LoopDetection();
        list1.push(20);
        list1.push(4);
        list1.push(15);
        list1.push(10);
        list1.createLoop(1);  // Create loop at position 1
        
        System.out.println("Using Hashing Method:");
        list1.printList();
        if (list1.detectLoopHashing()) {
            System.out.println("Loop detected");
        } else {
            System.out.println("No loop detected");
        }
        
        System.out.println("\nUsing Floyd's Method:");
        Node loopNode = list1.detectLoopFloyd();
        if (loopNode != null) {
            System.out.println("Loop detected starting at node with data: " + loopNode.data);
        } else {
            System.out.println("No loop detected");
        }
        
        // Test Case 2: List without loop
        System.out.println("\nTest Case 2: List without loop");
        LoopDetection list2 = new LoopDetection();
        list2.push(5);
        list2.push(4);
        list2.push(3);
        list2.push(2);
        list2.push(1);
        
        System.out.println("Using Hashing Method:");
        list2.printList();
        if (list2.detectLoopHashing()) {
            System.out.println("Loop detected");
        } else {
            System.out.println("No loop detected");
        }
        
        System.out.println("\nUsing Floyd's Method:");
        loopNode = list2.detectLoopFloyd();
        if (loopNode != null) {
            System.out.println("Loop detected starting at node with data: " + loopNode.data);
        } else {
            System.out.println("No loop detected");
        }
        
        // Test Case 3: Single node with self-loop
        System.out.println("\nTest Case 3: Single node with self-loop");
        LoopDetection list3 = new LoopDetection();
        list3.push(1);
        list3.createLoop(0);  // Create self-loop
        
        System.out.println("Using Hashing Method:");
        list3.printList();
        if (list3.detectLoopHashing()) {
            System.out.println("Loop detected");
        } else {
            System.out.println("No loop detected");
        }
        
        System.out.println("\nUsing Floyd's Method:");
        loopNode = list3.detectLoopFloyd();
        if (loopNode != null) {
            System.out.println("Loop detected starting at node with data: " + loopNode.data);
        } else {
            System.out.println("No loop detected");
        }
    }
}


//Test Case 1: List with loop
//Using Hashing Method:
//List: 10 -> 15 -> 4 -> 20 -> 4 (loop starts here)
//Loop starts at node with data: 4
//Loop detected
//
//Using Floyd's Method:
//Loop detected starting at node with data: 4
//
//Test Case 2: List without loop
//Using Hashing Method:
//List: 1 -> 2 -> 3 -> 4 -> 5 -> null
//No loop detected
//
//Using Floyd's Method:
//No loop detected
//
//Test Case 3: Single node with self-loop
//Using Hashing Method:
//List: 1 (loop starts here)
//Loop starts at node with data: 1
//Loop detected
//
//Using Floyd's Method:
//Loop detected starting at node with data: 1
