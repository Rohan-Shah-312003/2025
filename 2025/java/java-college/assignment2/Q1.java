/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/


class Solution {
    public static Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        // Using Floyd's Cycle Detection Algorithm
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;
        
        // Detect if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        // If no cycle exists
        if (!hasCycle) {
            return null;
        }
        
        // Find start of cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
}
