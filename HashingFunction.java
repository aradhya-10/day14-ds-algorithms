import java.io.*;
import java.util.*;

class Slot {
    private Map<Integer, OrderedList> slotMap;

    public Slot() {
        this.slotMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            slotMap.put(i, new OrderedList());
        }
    }

    public void insert(int number) {
        int slotIndex = number % 11;
        slotMap.get(slotIndex).insert(number);
    }

    public boolean search(int number) {
        int slotIndex = number % 11;
        OrderedList orderedList = slotMap.get(slotIndex);
        return contains(orderedList.head, number);
    }

    public void delete(int number) {
        int slotIndex = number % 11;
        OrderedList orderedList = slotMap.get(slotIndex);
        orderedList.delete(number);
    }

    public void display() {
        for (int i = 0; i < 10; i++) {
            System.out.print("Slot " + i + ": ");
            slotMap.get(i).display();
        }
    }

    public void writeToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < 10; i++) {
                OrderedList orderedList = slotMap.get(i);
                Node current = orderedList.head;
                while (current != null) {
                    writer.write(current.data + " ");
                    current = current.next;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean contains(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

public class HashingFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Slot slot = new Slot();

        // Read numbers from file and insert into the slots
        try {
            File file = new File("numbers.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextInt()) {
                int number = fileScanner.nextInt();
                slot.insert(number);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Take user input to search a number
        System.out.print("Enter a number to search: ");
        int searchNumber = scanner.nextInt();

        // Search for the number and display the result
        boolean isFound = slot.search(searchNumber);
        if (isFound) {
            System.out.println("Number " + searchNumber + " found in the slot.");
            slot.delete(searchNumber);
            System.out.println("Number " + searchNumber + " deleted from the slot.");
        } else {
            System.out.println("Number " + searchNumber + " not found in the slot.");
            slot.insert(searchNumber);
            System.out.println("Number " + searchNumber + " inserted in the appropriate slot.");
        }

        // Display the slots and write to a file
        System.out.println("Slots after operations:");
        slot.display();
        slot.writeToFile("updated_numbers.txt");

        scanner.close();
    }
}
