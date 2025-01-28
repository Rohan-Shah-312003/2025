
import java.util.*;
public class SortWOXtraSpace 
{
    private static int findMinIndex(Queue<Integer> queue, int sortedIndex) 
    {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        int size = queue.size();
        for (int i = 0; i < size; i++) 
        {
            int current = queue.poll();
            if (i <= sortedIndex && current < minValue)
            {
                minValue = current;
                minIndex = i;
            }
            queue.add(current);
        }
        return minIndex;
    }

    private static void moveToRear(Queue<Integer> queue, int minIndex) 
    {
        int size = queue.size();
        int minValue = 0;
        for (int i = 0; i < size; i++) 
        {
            int current = queue.poll();
            if (i == minIndex) 
            {
                minValue = current;
            } 
            else 
            {
                queue.add(current);
            }
        }
        queue.add(minValue);
    }
    public static void sortQueue(Queue<Integer> queue) 
    {
        int n = queue.size();
        for (int i = 0; i < n; i++) 
        {
            int minIndex = findMinIndex(queue, n - 1 - i);
            moveToRear(queue, minIndex);
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            queue.add(sc.nextInt());
        }
        sortQueue(queue);
        System.out.println(queue);
    }
}
