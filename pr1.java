import java.util.*;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        long startTime = System.nanoTime(); 

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            
            System.out.print("Pass " + (i + 1) + ": ");
            printArray(arr);
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

        selectionSort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);

        sc.close();
    }
}
/* Enter number of elements: 5
Enter elements:
64 25 12 22 11
Original array: 64 25 12 22 11
Pass 1: 11 25 12 22 64  
Pass 2: 11 12 25 22 64  
Pass 3: 11 12 22 25 64  
Pass 4: 11 12 22 25 64  
Execution Time: 153200 nanoseconds
Sorted array: 11 12 22 25 64. */
