//import java.util.*;
//
//public class BiotonicDLL {
//    static class Node {
//        int data;
//        Node next;
//        Node prev;
//
//        Node(int data) {
//            this.data = data;
//            this.next = null;
//            this.prev = null;
//        }
//    }
//
//    // Reverse a DLL
//    static Node reverse(Node head) {
//        Node temp = null;
//        Node current = head;
//
//        // Swap next and prev pointers for all nodes
//        while (current != null) {
//            temp = current.prev;
//            current.prev = current.next;
//            current.next = temp;
//            current = current.prev; // Move to next node
//        }
//
//        // Update head pointer
//        if (temp != null) {
//            head = temp.prev;
//        }
//
//        return head;
//    }
//
//    // Merge two sorted DLLs
//    static Node merge(Node first, Node second) {
//        // Base cases
//        if (first == null) return second;
//        if (second == null) return first;
//
//        // Pick the smaller value
//        if (first.data < second.data) {
//            first.next = merge(first.next, second);
//            if (first.next != null) {
//                first.next.prev = first;
//            }
//            first.prev = null;
//            return first;
//        } else {
//            second.next = merge(first, second.next);
//            if (second.next != null) {
//                second.next.prev = second;
//            }
//            second.prev = null;
//            return second;
//        }
//    }
//
//    // Sort biotonic DLL
//    static Node sort(Node head) {
//        // Handle base cases
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // Find the biotonic point
//        Node current = head;
//        while (current.next != null && current.next.data > current.data) {
//            current = current.next;
//        }
//
//        // If already sorted
//        if (current.next == null) {
//            return head;
//        }
//
//        // Split the list and reverse the second part
//        Node second = current.next;
//        current.next = null;
//        second.prev = null;
//
//        // Reverse the second part
//        second = reverse(second);
//
//        // Merge both parts
//        return merge(head, second);
//    }
//
//    // Add a node at the beginning
//    static Node push(Node head, int newData) {
//        Node newNode = new Node(newData);
//
//        newNode.next = head;
//        if (head != null) {
//            head.prev = newNode;
//        }
//
//        return newNode;
//    }
//
//    // Print the DLL
//    static void printList(Node head) {
//        if (head == null) {
//            System.out.println("Empty list");
//            return;
//        }
//
//        Node current = head;
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//        System.out.println();
//    }
//
//    // Verify if DLL is properly linked
//    static boolean verifyDLL(Node head) {
//        if (head == null) return true;
//
//        Node last = null;
//        Node current = head;
//
//        while (current != null) {
//            if (current.prev != last) return false;
//            last = current;
//            current = current.next;
//        }
//        return true;
//    }
//
//    // Verify if list is sorted
//    static boolean isSorted(Node head) {
//        if (head == null || head.next == null) return true;
//
//        Node current = head;
//        while (current.next != null) {
//            if (current.data > current.next.data) return false;
//            current = current.next;
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        // Test Case 1: Normal biotonic list
//        System.out.println("Test Case 1: Normal biotonic list");
//        Node head1 = null;
//        head1 = push(head1, 1);
//        head1 = push(head1, 4);
//        head1 = push(head1, 6);
//        head1 = push(head1, 10);
//        head1 = push(head1, 12);
//        head1 = push(head1, 7);
//        head1 = push(head1, 5);
//        head1 = push(head1, 2);
//
//        System.out.println("Original list:");
//        printList(head1);
//        head1 = sort(head1);
//        System.out.println("Sorted list:");
//        printList(head1);
//        System.out.println("DLL is properly linked: " + verifyDLL(head1));
//        System.out.println("List is sorted: " + isSorted(head1));
//
//        // Test Case 2: Already sorted list
//        System.out.println("\nTest Case 2: Already sorted list");
//        Node head2 = null;
//        head2 = push(head2, 5);
//        head2 = push(head2, 4);
//        head2 = push(head2, 3);
//        head2 = push(head2, 2);
//        head2 = push(head2, 1);
//
//        System.out.println("Original list:");
//        printList(head2);
//        head2 = sort(head2);
//        System.out.println("Sorted list:");
//        printList(head2);
//        System.out.println("DLL is properly linked: " + verifyDLL(head2));
//        System.out.println("List is sorted: " + isSorted(head2));
//
//        // Test Case 3: Single element
//        System.out.println("\nTest Case 3: Single element");
//        Node head3 = push(null, 1);
//        System.out.println("Original list:");
//        printList(head3);
//        head3 = sort(head3);
//        System.out.println("Sorted list:");
//        printList(head3);
//        System.out.println("DLL is properly linked: " + verifyDLL(head3));
//        System.out.println("List is sorted: " + isSorted(head3));
//
//        // Test Case 4: Empty list
//        System.out.println("\nTest Case 4: Empty list");
//        Node head4 = null;
//        System.out.println("Original list:");
//        printList(head4);
//        head4 = sort(head4);
//        System.out.println("Sorted list:");
//        printList(head4);
//        System.out.println("DLL is properly linked: " + verifyDLL(head4));
//        System.out.println("List is sorted: " + isSorted(head4));
//    }
//}
//
//
////Test Case 1: Normal biotonic list
////Original list:
////2 5 7 12 10 6 4 1
////Sorted list:
////1 2 4 5 6 7 10 12
////DLL is properly linked: true
////List is sorted: true
////
////Test Case 2: Already sorted list
////Original list:
////1 2 3 4 5
////Sorted list:
////1 2 3 4 5
////DLL is properly linked: true
////List is sorted: true
////
////Test Case 3: Single element
////Original list:
////1
////Sorted list:
////1
////DLL is properly linked: true
////List is sorted: true
////
////Test Case 4: Empty list
////Original list:
////Empty list
////Sorted list:
////Empty list
////DLL is properly linked: true
////List is sorted: true
//
//
//

import java.util.*;
class Node 
{
    int data;
    Node next, prev;
    Node(int data) 
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class BiotonicDLL 
{
    public static Node reverse(Node head) 
    {
        Node temp = null;
        Node current = head;
        while (current != null) 
        {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        return temp != null ? temp.prev : head; 
    }

    public static Node mergeSortedLists(Node first, Node second) 
    {
        if (first == null) 
return second;
        if (second == null) 
return first;
        Node dummy = new Node(0);
        Node current = dummy;
        while (first != null && second != null) 
        {
            if (first.data <= second.data)
            {
                current.next = first;
                first.prev = current;
                first = first.next;
            }
            else
            {
                current.next = second;
                second.prev = current;
                second = second.next;
            }
            current = current.next;
        }
        if (first != null) 
        {
            current.next = first;
            first.prev = current;
        }
        else if (second != null)
        {
            current.next = second;
            second.prev = current;
        }
        return dummy.next;
    }

    public static Node sortBitonicDoublyLinkedList(Node head) 
    {
        if (head == null || head.next == null) 
            return head;
        Node increasing = head;
        Node decreasing = head.next;
        while (decreasing != null && decreasing.next != null && decreasing.data <= decreasing.next.data) 
        {
            decreasing = decreasing.next;
        }
        if (decreasing != null) 
        {
            decreasing.prev.next = null;
            decreasing.prev = null;
        }
        decreasing = reverse(decreasing);
        return mergeSortedLists(increasing, decreasing);
    }
    public static void printList(Node head) 
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) 
        {
            int value = sc.nextInt();
            Node newNode = new Node(value);
            if (head == null) 
            {
                head = newNode;
                tail = newNode;
            } 
            else
            {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        head = sortBitonicDoublyLinkedList(head);
        printList(head);
    }
}
