import java.util.ArrayList;

public class PrimeNumberRanges {
    public static void main(String[] args) {
        // Define the range and the size of each range
        int startRange = 0;
        int endRange = 1000;
        int rangeSize = 100;
        int numRanges = (endRange - startRange) / rangeSize + 1;
        ArrayList<ArrayList<Integer>> primeRanges = new ArrayList<>();

        // Find and store prime numbers in each range
        for (int i = 0; i < numRanges; i++) {
            int currentStart = startRange + i * rangeSize;
            int currentEnd = currentStart + rangeSize - 1;
            
            ArrayList<Integer> primesInCurrentRange = findPrimesInRange(currentStart, currentEnd);
            primeRanges.add(primesInCurrentRange);
        }
        
        for (int i = 0; i < primeRanges.size(); i++) {
            System.out.println("Range " + i + ": " + primeRanges.get(i));
        }
    }

    // Function to find prime numbers in a given range
    private static ArrayList<Integer> findPrimesInRange(int start, int end) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        return primes;
    }

    // Function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
