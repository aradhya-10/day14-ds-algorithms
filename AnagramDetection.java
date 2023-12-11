import java.util.Arrays;
import java.util.Scanner;

public class AnagramDetection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read two strings from the user
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        // Check if the strings are anagrams
        boolean anagramCheck = checkIfAnagrams(str1, str2);

        if (anagramCheck) {
            System.out.println("The two strings are anagrams.");
        } else {
            System.out.println("The two strings are not anagrams.");
        }

        sc.close();
    }

    // Method to check if two strings are anagrams
    private static boolean checkIfAnagrams(String str1, String str2) {

		str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If the lengths are different, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}
