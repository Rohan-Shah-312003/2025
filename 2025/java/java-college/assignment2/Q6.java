class Solution {
    public static Node rearrange(Node head) {
        if (head == null || head.next == null) return head;
        
        Node even = null, odd = null;
        Node evenTail = null, oddTail = null;
        Node curr = head;
        
        // Single pass to separate even and odd
        while (curr != null) {
            if (curr.val % 2 == 0) {
                if (even == null) {
                    even = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            } else {
                if (odd == null) {
                    odd = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }
            Node next = curr.next;
            curr.next = null;
            curr = next;
        }
        
        if (even == null) return odd;
        evenTail.next = odd;
        return even;
    }
}
