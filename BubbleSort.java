import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read in the list of integers from the user
        System.out.print("Enter the list of integers separated by spaces: ");
        String input = sc.nextLine();
        String[] inputNumbers = input.split("\\s+");

        // Convert string array to integer array
        int[] numbers = new int[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        // Sort the integers using Bubble Sort
        bubbleSort(numbers);

        // Print the sorted list
        System.out.println("Sorted List:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    // Bubble Sort algorithm to sort an array of integers
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
