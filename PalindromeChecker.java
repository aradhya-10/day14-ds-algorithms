import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Check if the string is a palindrome
        boolean isPalindrome = isPalindrome(inputString);

        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }

    private static boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Add characters to the rear of the deque
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Process the deque from both ends and compare characters
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false; // Characters from both ends are not equal
            }
        }

        return true; // All characters matched, so it's a palindrome
    }
}
