import java.util.ArrayList;
import java.util.Arrays;

public class PrimeAnagramRanges {
    public static void main(String[] args) {
        int startRange = 0;
        int endRange = 1000;
        int rangeSize = 100;
        
        int numRanges = (endRange - startRange) / rangeSize + 1;

        ArrayList<ArrayList<Integer>> primeAnagramRanges = new ArrayList<>();

        // Find and store prime numbers and anagrams in each range
        for (int i = 0; i < numRanges; i++) {
            int currentStart = startRange + i * rangeSize;
            int currentEnd = currentStart + rangeSize - 1;

            ArrayList<Integer> primesInCurrentRange = findPrimesInRange(currentStart, currentEnd);
            ArrayList<Integer> anagrams = findAnagrams(primesInCurrentRange);

            ArrayList<Integer> nonAnagrams = new ArrayList<>(primesInCurrentRange);
            nonAnagrams.removeAll(anagrams);

            ArrayList<Integer> currentRangeData = new ArrayList<>();
            currentRangeData.addAll(anagrams);
            currentRangeData.addAll(nonAnagrams);

            primeAnagramRanges.add(currentRangeData);
        }

        // Display the 2D array
        for (int i = 0; i < primeAnagramRanges.size(); i++) {
            System.out.println("Range " + i + ": " + primeAnagramRanges.get(i));
        }
    }
    private static ArrayList<Integer> findPrimesInRange(int start, int end) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        return primes;
    }

    // Function to find anagrams in a list of numbers
    private static ArrayList<Integer> findAnagrams(ArrayList<Integer> numbers) {
        ArrayList<Integer> anagrams = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (areAnagrams(numbers.get(i), numbers.get(j))) {
                    if (!anagrams.contains(numbers.get(i))) {
                        anagrams.add(numbers.get(i));
                    }
                    if (!anagrams.contains(numbers.get(j))) {
                        anagrams.add(numbers.get(j));
                    }
                }
            }
        }

        return anagrams;
    }

    // Function to check if two numbers are anagrams
    private static boolean areAnagrams(int num1, int num2) {
        char[] charArray1 = String.valueOf(num1).toCharArray();
        char[] charArray2 = String.valueOf(num2).toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
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
