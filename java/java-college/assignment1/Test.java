// Node class definition
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedListSolutions {
    // 1. Split List into Even and Odd Lists
    public ListNode[] splitEvenOdd(ListNode head) {
        if (head == null) return new ListNode[]{null, null};
        
        ListNode evenHead = null, evenTail = null;
        ListNode oddHead = null, oddTail = null;
        ListNode current = head;
        
        while (current != null) {
            if (current.val % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = new ListNode(current.val);
                } else {
                    evenTail.next = new ListNode(current.val);
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = new ListNode(current.val);
                } else {
                    oddTail.next = new ListNode(current.val);
                    oddTail = oddTail.next;
                }
            }
            current = current.next;
        }
        
        return new ListNode[]{evenHead, oddHead};
    }
    
    // 2. Remove Loop in Linked List
    public ListNode removeLoop(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Detect loop using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        
        // If no loop exists
        if (fast == null || fast.next == null) return head;
        
        // Find start of loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Find last node in loop
        while (fast.next != slow) {
            fast = fast.next;
        }
        
        // Remove loop
        fast.next = null;
        return head;
    }
    
    // 3. Reverse Linked List
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }
    
    // 4. Find Middle Node
    public ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // 5. Remove Duplicates from Sorted List
    public ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode current = head;
        
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
    
    // Utility method to print list (for testing)
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Test { 
    public static void main(String[] args) {
        LinkedListSolutions solution = new LinkedListSolutions();
        
        System.out.println("====== Linked List Operations Demo ======\n");
        
        // Test 1: Split List into Even and Odd
        System.out.println("1. Split List into Even and Odd");
        System.out.println("-----------------------------------");
        ListNode list1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original list:");
        solution.printList(list1);
        
        ListNode[] split = solution.splitEvenOdd(list1);
        System.out.println("Even numbers list:");
        solution.printList(split[0]);
        System.out.println("Odd numbers list:");
        solution.printList(split[1]);
        System.out.println();
        
        // Test 2: Remove Loop
        System.out.println("2. Remove Loop from Linked List");
        System.out.println("-----------------------------------");
        ListNode loopList = createLoopedList();
        System.out.println("List with loop created (1->2->3->4->5->2)");
        ListNode fixedList = solution.removeLoop(loopList);
        System.out.println("After removing loop:");
        solution.printList(fixedList);
        System.out.println();
        
        // Test 3: Reverse Linked List
        System.out.println("3. Reverse Linked List");
        System.out.println("-----------------------------------");
        ListNode list3 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original list:");
        solution.printList(list3);
        ListNode reversedList = solution.reverseList(list3);
        System.out.println("Reversed list:");
        solution.printList(reversedList);
        System.out.println();
        
        // Test 4: Find Middle Node
        System.out.println("4. Find Middle Node");
        System.out.println("-----------------------------------");
        ListNode list4 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original list:");
        solution.printList(list4);
        ListNode middle = solution.findMiddle(list4);
        System.out.println("Middle node value: " + middle.val);
        System.out.println();
        
        // Test 5: Remove Duplicates
        System.out.println("5. Remove Duplicates from Sorted List");
        System.out.println("-----------------------------------");
        ListNode list5 = createList(new int[]{1, 1, 2, 3, 3, 4});
        System.out.println("Original list with duplicates:");
        solution.printList(list5);
        ListNode uniqueList = solution.removeDuplicates(list5);
        System.out.println("After removing duplicates:");
        solution.printList(uniqueList);
    }
    
    // Utility method to create a linked list from array
    private static ListNode createList(int[] values) {
        if (values == null || values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    // Utility method to create a linked list with a loop
    private static ListNode createLoopedList() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;  // Creating loop back to node2
        
        return head;
    }
}
