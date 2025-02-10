// Node is defined as:
// class Node{
//     int val;
//     Node next;
//     Node(){
//         val =0;
//         next = null;
//     }
//     Node(int x){
//     	val = x; next = null;
//     }
// }
class Solution{
    public static int solve(Node head) {
        // If list is empty or has only one node
        if (head == null || head.next == null) {
            return -1;
        }
        
        Node slow = head;
        Node fast = head;
        boolean hasLoop = false;
        
        // Detect if loop exists using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }
        
        // If no loop exists
        if (!hasLoop) {
            return -1;
        }
        
        // Count the length of the loop
        int count = 1;  // Start from 1 instead of 0
        slow = slow.next;  // Move to next node before starting count
        
        while (slow != fast) {
            slow = slow.next;
            count++;
        }
        
        return count;  // Return the actual loop length without subtracting 1
    }
}
