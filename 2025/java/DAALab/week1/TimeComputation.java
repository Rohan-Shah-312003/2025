import java.util.*;
public class TimeComputation {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            System.out.println(i); 
        }

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
