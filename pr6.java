import java.util.*;

public class SearchBoth {

    // Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        System.out.println("\nChoose method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int choice = sc.nextInt();

        int result = -1;

        switch (choice) {
            case 1:
                result = linearSearch(arr, key);
                break;

            case 2:
                Arrays.sort(arr); // Binary search needs sorted array
                System.out.print("Sorted array: ");
                for (int num : arr)
                    System.out.print(num + " ");
                System.out.println();

                result = binarySearch(arr, key);
                break;

            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
/* output 
Enter number of elements: 5
Enter elements:
10
8
4
5
20
Enter element to search: 20

Choose method:
1. Linear Search
2. Binary Search
2
Sorted array: 4 5 8 10 20 
Element found at index: 4 */
