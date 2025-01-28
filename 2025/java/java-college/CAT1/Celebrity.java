import java.util.*;

public class Celebrity {
    static boolean knows(int a, int b, int[][] r) {
        return r[a][b] == 1;
    }
    
    static int findCelebrity(int n, int[][] m) {
        Stack<Integer> st = new Stack<>();
        
        // Push all people to stack
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        
        // Find potential celebrity
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            
            if (knows(a, b, m)) {
                // If a knows b, then a cannot be celebrity
                st.push(b);
            } else {
                // If a doesn't know b, then b cannot be celebrity
                st.push(a);
            }
        }
        
        if (st.isEmpty()) {
            return -1;
        }
        
        // Check if the last person is actually a celebrity
        int c = st.pop();
        
        // Verify that c doesn't know anyone and everyone knows c
        for (int j = 0; j < n; j++) {
            if (j != c) {
                if (knows(c, j, m) || !knows(j, c, m)) {
                    return -1;
                }
            }
        }
        
        return c;
    }
    
    public static void main(String[] args) {
        // Test Case 1: Has a celebrity
        int[][] matrix1 = {
            {0, 1, 0},
            {0, 0, 0},
            {1, 1, 0}
        };
        int n1 = 3;
        
        // Test Case 2: No celebrity
        int[][] matrix2 = {
            {0, 1, 0},
            {1, 0, 0},
            {1, 1, 0}
        };
        int n2 = 3;
        
        // Test Case 3: Single person
        int[][] matrix3 = {{0}};
        int n3 = 1;
        
        System.out.println("Test Case 1 (Has celebrity):");
        System.out.println("Matrix:");
        printMatrix(matrix1);
        int result1 = findCelebrity(n1, matrix1);
        System.out.println("Celebrity: " + result1);
        
        System.out.println("\nTest Case 2 (No celebrity):");
        System.out.println("Matrix:");
        printMatrix(matrix2);
        int result2 = findCelebrity(n2, matrix2);
        System.out.println("Celebrity: " + result2);
        
        System.out.println("\nTest Case 3 (Single person):");
        System.out.println("Matrix:");
        printMatrix(matrix3);
        int result3 = findCelebrity(n3, matrix3);
        System.out.println("Celebrity: " + result3);
    }
    
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}


//Test Case 1 (Has celebrity):
//Matrix:
//[0, 1, 0]
//[0, 0, 0]
//[1, 1, 0]
//Celebrity: 1
//
//Test Case 2 (No celebrity):
//Matrix:
//[0, 1, 0]
//[1, 0, 0]
//[1, 1, 0]
//Celebrity: -1
//
//Test Case 3 (Single person):
//Matrix:
//[0]
//Celebrity: 0
