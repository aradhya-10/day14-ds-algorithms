import java.util.Scanner;

public class InsertionSort {

	// Insertion Sort algorithm to sort an array of strings
    private static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key to one position ahead of their current position
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read in the list of words from the user
        System.out.print("Enter the list of words separated by spaces: ");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        // Sort the words using Insertion Sort
        insertionSort(words);

        // Print the sorted list
        System.out.println("Sorted List:");
        for (String word : words) {
            System.out.print(word + " ");
        }

        scanner.close();
    }

}
