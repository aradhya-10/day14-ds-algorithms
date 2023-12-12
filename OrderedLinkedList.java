import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class OrderedList {
    Node head;

    OrderedList() {
        this.head = null;
    }

    // Function to insert a number into the ordered linked list
    void insert(int newData) {
        Node newNode = new Node(newData);
        if (head == null || head.data >= newData) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < newData) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Function to delete a number from the ordered linked list
    void delete(int key) {
        Node temp = head, prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println(key + " not found in the list.");
            return;
        }

        prev.next = temp.next;
    }

    // Function to display the ordered linked list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Function to write the ordered linked list to a file
    void writeToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            Node current = head;
            while (current != null) {
                writer.write(current.data + " ");
                current = current.next;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class OrderedLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderedList orderedList = new OrderedList();

        // Read numbers from file and insert into the ordered linked list
        try {
            File file = new File("numbers.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextInt()) {
                int number = fileScanner.nextInt();
                orderedList.insert(number);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Take user input for a new number
        System.out.print("Enter a new number: ");
        int newNumber = scanner.nextInt();

        // Check if the number exists and perform the required operation
        if (orderedList.head != null && contains(orderedList.head, newNumber)) {
            orderedList.delete(newNumber);
            System.out.println(newNumber + " found and deleted from the list.");
        } else {
            orderedList.insert(newNumber);
            System.out.println(newNumber + " inserted in the appropriate position.");
        }

        // Display the updated list and write it to a file
        System.out.print("Updated List: ");
        orderedList.display();
        orderedList.writeToFile("updated_numbers.txt");

        scanner.close();
    }

    // Helper function to check if a number exists in the linked list
    private static boolean contains(Node head, int key) {
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
