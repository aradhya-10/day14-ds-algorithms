// import java.util.Arrays;

import java.util.Scanner;

public class MergeSort {
	
    // Method to print an array
    private static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // Merge Sort algorithm for an array of strings
    private static void mergeSort(String[] arr, int low, int high) {
        if (high - low > 1) {
            int mid = low + (high - low) / 2;

            // Recursively sort the two halves
            mergeSort(arr, low, mid);
            mergeSort(arr, mid, high);

            // Merge the sorted halves
            merge(arr, low, mid, high);
        }
    }

    // Merge Function
    private static void merge(String[] arr, int low, int mid, int high) {
        String[] temp = new String[high - low];
        int i = low, j = mid, k = 0;

        while (i < mid && j < high) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }

        while (j < high) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, low, temp.length);
    }
	
    public static void main(String[] args) {
        // String[] strings = { "apple", "orange", "banana", "grape", "kiwi", "pear" };
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter strings separated by spaces: ");
        String input = sc.nextLine();
		sc.close();

        // Split the input string by spaces 
        String[] strings = input.split("\\s+");

        System.out.println("\nOriginal Array:");
        printArray(strings);

        // Perform Merge Sort
        mergeSort(strings, 0, strings.length);

        System.out.println("\nSorted Array:");
        printArray(strings);
    }
}
