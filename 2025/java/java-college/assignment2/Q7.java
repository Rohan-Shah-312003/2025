class PairWiseSwap {
    public static Node pairwiseSwap(Node head) {
        if (head == null || head.next == null) return head;
        
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        
        int index = 1;
        while (curr != null && curr.next != null) {
            if (index % 2 == 1) {
                // Store next pointers
                Node nextPair = curr.next.next;
                Node second = curr.next;
                
                // Swap nodes
                prev.next = second;
                second.next = curr;
                curr.next = nextPair;
                
                // Move prev to the last handled node
                prev = curr;
                curr = nextPair;
            }
            index++;
        }
        
        return dummy.next;
    }
}
