import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BinarySearch {

    private static String getUserInput() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter the word you want to search: ");
        String word = sc.nextLine();
		sc.close();
		return word;
    }
    public static void main(String[] args) {
        // Change the file path to your input file containing comma-separated words
        String filePath = "input_words.txt";

        try {
            // Read words from the file
            String[] words = readWordsFromFile(filePath);

            // Sort the words array
            Arrays.sort(words);

            // Prompt the user to enter a word to search
            String searchWord = getUserInput();

            // Perform binary search
            boolean found = binarySearch(words, searchWord);

            // Print the result
            if (found) {
                System.out.println("The word '" + searchWord + "' is found in the list.");
            } else {
                System.out.println("The word '" + searchWord + "' is not found in the list.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Read words from a file and return them as an array
    private static String[] readWordsFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        reader.close();
        return line.split(",\\s*"); // Split words by comma and optional whitespace
    }

    private static boolean binarySearch(String[] words, String searchWord) {
        int left = 0;
        int right = words.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compare = searchWord.compareTo(words[mid]);

            // Check if the word is present at mid
            if (compare == 0) {
                return true;
            }

            // If the search word is greater, ignore the left half
            if (compare > 0) {
                left = mid + 1;
            }
            // If the search word is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // If the word is not found
        return false;
    }

}
