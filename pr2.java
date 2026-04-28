import java.util.*;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        long startTime = System.nanoTime(); // Start time

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Print each pass
            System.out.print("Pass " + (i + 1) + ": ");
            printArray(arr);

            // Stop early if sorted
            if (!swapped) break;
        }

        long endTime = System.nanoTime(); // End time

        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " nanoseconds");
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Original array: ");
        printArray(arr);

        bubbleSort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);

        sc.close();
    }
}
/* output 
5
64 34 25 12 22
Original array: 64 34 25 12 22
Pass 1: 34 25 12 22 64  
Pass 2: 25 12 22 34 64  
Pass 3: 12 22 25 34 64  
Pass 4: 12 22 25 34 64  
Execution Time: 145600 nanoseconds
Sorted array: 12 22 25 34 64 */
