import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpecialPrimes {

    // Method to find prime numbers within a specified range using Sieve of Eratosthenes
    private static List<Integer> findPrimesInRange(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        for (int p = 2; p * p <= max; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
                System.out.print(i + " ");
            }
        }
        return primes;
    }

    // Method to find prime numbers that are anagrams
    private static void findAnagramPrimes(List<Integer> primes) {
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(primes.get(i), primes.get(j))) {
                    System.out.print("("+primes.get(i) + ", " + primes.get(j) + ") ");
                }
            }
        }
    }

    // Method to check if two numbers are anagrams
    private static boolean areAnagrams(int num1, int num2) {
        char[] arr1 = Integer.toString(num1).toCharArray();
        char[] arr2 = Integer.toString(num2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // Method to find prime numbers that are palindromes
    private static void findPalindromePrimes(List<Integer> primes) {
        for (int prime : primes) {
            if (isPalindrome(prime)) {
                System.out.print(prime + " ");
            }
        }
    }

    // Method to check if a number is palindrome
    private static boolean isPalindrome(int number) {
        int temp = number, reverse = 0;
        while (temp != 0) {
            int remainder = temp % 10;
            reverse = reverse * 10 + remainder;
            temp /= 10;
        }
        return number == reverse;
    }

    public static void main(String[] args) {
        int range = 1000;

        System.out.println("Prime numbers between 0 and " + range + ":");
        List<Integer> primes = findPrimesInRange(range);

        System.out.println("\nPrime numbers that are anagrams:");
        findAnagramPrimes(primes);

        System.out.println("\nPrime numbers that are palindromes:");
        findPalindromePrimes(primes);
    }
}
