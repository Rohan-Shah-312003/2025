public class QuickSort {

    // Function to perform quicksort with a given pivot selection strategy
    public static void quickSort(int[] arr, int low, int high, String pivotType) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, pivotType);
            quickSort(arr, low, pivotIndex - 1, pivotType);  // Left subarray
            quickSort(arr, pivotIndex + 1, high, pivotType); // Right subarray
        }
    }

    // Function to partition the array around the pivot
    public static int partition(int[] arr, int low, int high, String pivotType) {
        int pivot = choosePivot(arr, low, high, pivotType);
        int i = low - 1;
        
        // Move pivot to the end for ease of partitioning
        if (pivot != high) {
            swap(arr, pivot, high);
        }

        for (int j = low; j < high; j++) {
            if (arr[j] <= arr[high]) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Move pivot to its correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Function to choose the pivot based on pivot type
    public static int choosePivot(int[] arr, int low, int high, String pivotType) {
        switch (pivotType) {
            case "start":
                return low; // Pivot is the first element
            case "middle":
                return (low + high) / 2; // Pivot is the middle element
            case "end":
                return high; // Pivot is the last element
            default:
                throw new IllegalArgumentException("Invalid pivot type");
        }
    }

    // Function to swap elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test the three pivot strategies
    public static void main(String[] args) {
        // Example array to be sorted
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Original array:");
        printArray(arr);
        
        // Sort with pivot at start
        int[] arrStart = arr.clone();
        quickSort(arrStart, 0, arrStart.length - 1, "start");
        System.out.println("\nSorted with pivot at start:");
        printArray(arrStart);

        // Sort with pivot in middle
        int[] arrMiddle = arr.clone();
        quickSort(arrMiddle, 0, arrMiddle.length - 1, "middle");
        System.out.println("\nSorted with pivot in middle:");
        printArray(arrMiddle);

        // Sort with pivot at end
        int[] arrEnd = arr.clone();
        quickSort(arrEnd, 0, arrEnd.length - 1, "end");
        System.out.println("\nSorted with pivot at end:");
        printArray(arrEnd);
    }

    // Helper function to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
