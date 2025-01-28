
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

public class SortEvenOddLL 
{
    public static Node segregateEvenOdd(Node head) 
    {
        if (head == null || head.next == null) 
            return head;
        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        Node current = head;
        while (current != null) 
        {
            if (current.data % 2 == 0) 
            { 
                if (evenStart == null) 
                {
                    evenStart = current;
                    evenEnd = evenStart;
                } else 
                {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } 
            else 
            { 
                if (oddStart == null) 
                {
                    oddStart = current;
                    oddEnd = oddStart;
                }
                else 
                {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }
        if (evenStart == null) 
            return oddStart;
        if (oddStart == null) 
            return evenStart;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    public static void printList(Node head) 
    {
        Node current = head;
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
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
                tail = newNode;
            }
        }
        head = segregateEvenOdd(head);
        printList(head);
    }
}
