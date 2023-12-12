import java.util.ArrayList;
import java.util.Arrays;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;

    Queue() {
        this.front = this.rear = null;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    boolean isEmpty() {
        return front == null;
    }
}

public class PrimeAnagramQueue {
    public static void main(String[] args) {
        // Define the range
        int startRange = 0;
        int endRange = 1000;

        // Find prime numbers in the range
        ArrayList<Integer> primesInRange = findPrimesInRange(startRange, endRange);

        // Find prime numbers that are anagrams
        ArrayList<Integer> anagrams = findAnagrams(primesInRange);

        // Create a queue and enqueue anagrams onto it
        Queue anagramQueue = new Queue();
        for (int anagram : anagrams) {
            anagramQueue.enqueue(anagram);
        }

        // Print the anagrams from the queue
        System.out.println("Anagrams from the queue:");
        while (!anagramQueue.isEmpty()) {
            System.out.print(anagramQueue.dequeue() + " ");
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
