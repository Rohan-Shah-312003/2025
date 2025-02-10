/*class Node{
    int val;
    Node next;
    Node(int x){
    	val = x; next = null;
    }
}*/

static Node rotateRight(Node head, int R){
    

        // Handle edge cases
        if (head == null || head.next == null || R == 0) {
            return head;
        }
        
        // Find length of list and last node
        Node current = head;
        int length = 1;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        
        // Make the list circular
        current.next = head;
        
        // Normalize R to be within list length
        R = R % length;
        
        // Find the new last node (length - R - 1 steps from head)
        current = head;
        for (int i = 0; i < length - R - 1; i++) {
            current = current.next;
        }
        
        // Break the circular list and set new head
        head = current.next;
        current.next = null;
        
        return head;
    }
