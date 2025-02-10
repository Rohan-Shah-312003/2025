import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }
        
        int x = Integer.parseInt(br.readLine());
        int deepestPos = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (stack.get(i) == x) {
                deepestPos = i + 1;
            }
        }
        
        System.out.println(deepestPos);
    }
}
