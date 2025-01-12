import java.util.Scanner;

/**
 * QuickSort
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }


    }

    static int partitionHigh(int[] a, int low, int high) {
        int pivot = a[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    static int partitionLow(int[] a, int low, int high) {
        int pivot = a[low];
        int i = (low + 1);
        for (int j = low + 1; j <= high; j++) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        int temp = a[i - 1];
        a[i - 1] = a[low];
        a[low] = temp;

        return i - 1;
    }

    static int partitionMid(int[] a, int low, int high) {
        int middleIndex = (high + low) / 2;
        int pivot = a[middleIndex];

        int temp = a[middleIndex];
        a[middleIndex] = a[high];
        a[high] = temp;

        int i = low - 1;
        // upper half
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
    }

    static void quickSortHigh(int a[], int l, int h) {
        if (l < h) {
            int pi = partitionHigh(a, l, h);
            quickSortHigh(a, l, pi - 1);
            quickSortHigh(a, pi - 1, h);
        }
    }
    
    static void quickSortLow(int a[], int l, int h) {
        if (l < h) {
            int pi = partitionLow(a, l, h);
            quickSortLow(a, l, pi - 1);
            quickSortLow(a, pi + 1, h);
        }
    }

    static void quickSortMid(int a[], int l, int h) {
        if (l < h) {
            int pi = partition(a, l, h);
            quickSort(a, l, pi - 1);
            quickSort(a, pi - 1, h);
        }
    }
    static void displayArray(int a[]) {
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
