import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomStack stack = new CustomStack();
        
        int q = sc.nextInt(); // number of queries
        
        for(int i = 0; i < q; i++) {
            int queryType = sc.nextInt();
            
            switch(queryType) {
                case 1: // Push single element
                    int element = sc.nextInt();
                    stack.push(element);
                    break;
                    
                case 2: // Push element n times
                    int n = sc.nextInt();
                    int x = sc.nextInt();
                    stack.pushNTimes(n, x);
                    break;
                    
                case 3: // Print and pop top element
                    System.out.println(stack.popAndPrint());
                    break;
                    
                case 4: // Pop n elements and print sum
                    int count = sc.nextInt();
                    System.out.println(stack.popNAndSum(count));
                    break;
                    
                case 5: // Print sum of all elements
                    System.out.println(stack.getSum());
                    break;
            }
        }
        sc.close();
    }
}

class CustomStack {
    private ArrayList<Integer> stack;
    private long totalSum; // Using long to handle large sums
    
    public CustomStack() {
        stack = new ArrayList<>();
        totalSum = 0;
    }
    
    public void push(int x) {
        stack.add(x);
        totalSum += x;
    }
    
    public void pushNTimes(int n, int x) {
        for(int i = 0; i < n; i++) {
            push(x);
        }
    }
    
    public int popAndPrint() {
        if(stack.isEmpty()) {
            return 0;
        }
        int top = stack.remove(stack.size() - 1);
        totalSum -= top;
        return top;
    }
    
    public long popNAndSum(int n) {
        long sum = 0;
        int elementsToRemove = Math.min(n, stack.size());
        
        for(int i = 0; i < elementsToRemove; i++) {
            sum += stack.get(stack.size() - 1);
            totalSum -= stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
        }
        
        return sum;
    }
    
    public long getSum() {
        return totalSum;
    }
}
