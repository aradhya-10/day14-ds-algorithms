import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {

    // Iterative method to generate permutations of a string
    public static List<String> iterativePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add("");

        for (char c : str.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String permutation : permutations) {
                for (int i = 0; i <= permutation.length(); i++) {
                    newPermutations.add(permutation.substring(0, i) + c + permutation.substring(i));
                }
            }
            permutations = newPermutations;
        }

        return permutations;
    }

    // Recursive method to generate permutations of a string
    public static List<String> recursivePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        generatePermutations("", str, permutations);
        return permutations;
    }

    private static void generatePermutations(String prefix, String remaining, List<String> permutations) {
        int n = remaining.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, n), permutations);
            }
        }
    }

    // Method to check if two arrays of strings are equal
    public static boolean areArraysEqual(List<String> arr1, List<String> arr2) {
        if (arr1.size() != arr2.size()) {
            return false;
        }
        String[] arr1Array = arr1.toArray(new String[0]);
        String[] arr2Array = arr2.toArray(new String[0]);
        Arrays.sort(arr1Array);
        Arrays.sort(arr2Array);
        return Arrays.equals(arr1Array, arr2Array);
    }

    public static void main(String[] args) {
        String input = "abcd";

        List<String> iterativeResult = iterativePermutations(input);
        System.out.println("Iterative Permutations: " + iterativeResult);
		
        List<String> recursiveResult = recursivePermutations(input);
        System.out.println("Recursive Permutations: " + recursiveResult);

        // Check if the arrays returned by both methods are equal
        boolean areEqual = areArraysEqual(iterativeResult, recursiveResult);
        System.out.println("Are arrays equal? " + areEqual);
    }
}
