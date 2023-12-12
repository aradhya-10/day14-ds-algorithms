import java.io.*;
import java.util.*;

class Node {
	String data;
	Node next;

	Node(String data) {
		this.data = data;
		this.next = null;
	}
}

public class UnorderedList {

	private Node head;
	static boolean found = true;
	public void insert(String data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void delete(String data) {
		Node temp = head;
		Node prev = null;

		if (temp != null && temp.data.equals(data)) {
			head = temp.next;
			return;
		}

		while (temp != null && !temp.data.equals(data)) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Word not found in the list.");
			found = false;
			return;
		}

		prev.next = temp.next;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void saveToFile(String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			Node temp = head;
			while (temp != null) {
				writer.write(temp.data + " ");
				temp = temp.next;
			}
			System.out.println("List saved to file: " + fileName);
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		UnorderedList list = new UnorderedList();
		Scanner scanner = new Scanner(System.in);

		try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					list.insert(word);
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading from file: " + e.getMessage());
		}

		System.out.println("List from file:");
		list.display();

		System.out.print("Enter a word to search/delete/add: ");
		String word = scanner.next();

		if (list.head != null) {

			list.delete(word);
			System.out.println(word + " removed from the list.");

			if (found == false){
				list.insert(word);
				System.out.println(word + " added to the list.");
			}
		}

		System.out.println("Modified List:");
		list.display();
		list.saveToFile("output.txt");

		scanner.close();
	}
}
