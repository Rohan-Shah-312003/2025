import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

      class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

*****************************************************************/
public class Solution {
    public static Node<Integer> sortDLL(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Count number of nodes
        int length = 0;
        Node<Integer> current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Create array to store values
        Integer[] arr = new Integer[length];
        current = head;
        int index = 0;
        
        // Store values in array
        while (current != null) {
            arr[index++] = current.data;
            current = current.next;
        }
        
        // Sort array
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    Integer temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        // Update linked list with sorted values
        current = head;
        index = 0;
        while (current != null) {
            current.data = arr[index++];
            current = current.next;
        }
        
        return head;
    }
}
