
import java.util.*;
class Node {
    int data;
    Node next, prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class MergeSortDLL 
{
    private static Node split(Node head)
    {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = slow.next;
        slow.next = null;
        if (secondHalf != null) 
        {
            secondHalf.prev = null;
        }
        return secondHalf;
    }

    private static Node merge(Node first, Node second) 
    {
        if (first == null)
 return second;
        if (second == null) return first;
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

    public static Node mergeSort(Node head) 
    {
        if (head == null || head.next == null) 
            return head;
        Node secondHalf = split(head); 
        head = mergeSort(head);       
        secondHalf = mergeSort(secondHalf); 
        return merge(head, secondHalf); 
    }

    private static void printList(Node head)
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

 public static void main(String[] args) 
 {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        if (size <= 0) 
        {
            System.out.println("0");
        }
        Node head = null, tail = null;
        for (int i = 0; i < size; i++) 
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
        head = mergeSort(head);
        printList(head);
    }
}
