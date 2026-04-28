import java.util.*;

public class QuickSort {

  
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        
        System.out.print("Partition (pivot=" + pivot + "): ");
        printArray(arr);

        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Original array: ");
        printArray(arr);

        long startTime = System.nanoTime(); // Start time

        quickSort(arr, 0, n - 1);

        long endTime = System.nanoTime(); // End time

        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " nanoseconds");

        System.out.print("Sorted array: ");
        printArray(arr);

        sc.close();
    }
}
/*output 
Enter number of elements: 5
Enter elements:
10
8
4
5
20
Original array: 10 8 4 5 20 
Partition (pivot=20): 10 8 4 5 20 
Partition (pivot=5): 4 5 10 8 20 
Partition (pivot=8): 4 5 8 10 20 
Execution Time: 861080 nanoseconds
Sorted array: 4 5 8 10 20 */
