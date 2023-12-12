import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModifyMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        // Replace <<name>> with first name
        String firstName = "John"; 
        message = message.replaceAll("<<name>>", firstName);

        // Replace <<full name>> with user's full name
        String fullName = "John Doe"; 
        message = message.replaceAll("<<full name>>", fullName);

        // Replace 91-xxxxxxxxxx with user's contact number
        String contactNumber = "91-1234567890"; 
        message = message.replaceAll("91-[xX]{10}", contactNumber);

        // Replace XX/XX/XXXX with current date
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", formattedDate);

        System.out.println("Modified Message:");
        System.out.println(message);

        scanner.close();
    }
}
