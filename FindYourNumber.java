import java.util.Scanner;

public class FindYourNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking command-line argument N
        System.out.print("Enter the value of N (where N = 2^n): ");
        int N = scanner.nextInt();
        int low = 0;
        int high = N - 1;

        int guess = findNumber(low, high, scanner);
        System.out.println("The guessed number is: " + guess);

        scanner.close();
    }

    // Recursive method to guess the number using binary search
    private static int findNumber(int low, int high, Scanner scanner) {
        if (low == high) {
            return low;
        }

        int mid = (low + high) / 2;

        System.out.println("Is your number between " + low + " and " + mid + " inclusive? (true/false)");
        boolean response = scanner.nextBoolean();

        if (response) {
            return findNumber(low, mid, scanner);
        } else {
            return findNumber(mid + 1, high, scanner);
        }
    }
}
