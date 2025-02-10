import java.util.*;

public class MinimumStack {
    private Stack<Integer> st;      // Main stack
    private Stack<Integer> mst;     // Minimum stack
    
    public MinimumStack() {
        st = new Stack<>();
        mst = new Stack<>();
    }
    
    public int getMin() {
        if (mst.isEmpty())
            throw new EmptyStackException();
        return mst.peek();
    }
    
    public int peek() {
        if (st.isEmpty())
            throw new EmptyStackException();
        return st.peek();
    }
    
    public void pop() {
        if (st.isEmpty())
            throw new EmptyStackException();
            
        int t = st.pop();
        if (t == mst.peek())
            mst.pop();
    }
    
    public void push(int x) {
        st.push(x);
        if (mst.isEmpty() || x <= mst.peek()) {
            mst.push(x);
        }
    }
    
    public boolean isEmpty() {
        return st.isEmpty();
    }
    
    public static void main(String[] args) {
        try {
            MinimumStack s = new MinimumStack();
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();
            
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                s.push(num);
                System.out.println("Pushed: " + num + ", Current min: " + s.getMin());
            }
            
            System.out.println("\nTesting stack operations:");
            while (!s.isEmpty()) {
                System.out.println("Top element: " + s.peek());
                System.out.println("Current minimum: " + s.getMin());
                s.pop();
                System.out.println("After pop");
            }
            
            sc.close();
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers only.");
        }
    }
}


/*
Enter number of elements: 5
Enter 5 elements:
3 2 5 1 4
*/
