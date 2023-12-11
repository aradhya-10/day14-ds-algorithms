// Using sieve Of Eratosthenes 

public class CheckPrime {

    public static void main(String[] args) {
        int range = 1000;

        System.out.println("Prime numbers between 0 and " + range + ":");
        findPrimesInRange(range);
    }

    // Method to find prime numbers within a specified range using Sieve of Eratosthenes
    private static void findPrimesInRange(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= max; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Print prime numbers
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
