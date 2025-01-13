import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Person;
import java.util.*;

public class DatabaseControllerImpl {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }


    public static void launch(Scanner scanner) {
        System.out.println("Welcome to the Terminal REST App (Person Management with File I/O)!");
        System.out.println("Available commands:");
        System.out.println("1. GET [id] - Retrieve a person by ID");
        System.out.println("2. POST-SETTERS - Create a new person using setters");
        System.out.println("3. DELETE [id] - Delete a person by ID");
        System.out.println("4. PRINT - Print all people in JSON format");
        System.out.println("5. EXIT - Exit the application");
        System.out.println();

        PersonService.loadDatabase();

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            String[] parts = input.split(" ", 2);
            String command = parts[0].toUpperCase();

            switch (command) {
                case "GET":
                    handleGet(parts);
                    break;
                case "POST-SETTERS":
                    handlePostUsingSetters(scanner);
                    break;
                case "DELETE":
                    handleDelete(parts);
                    break;
                case "PRINT":
                    handlePrint();
                    break;
                case "EXIT":
                    System.out.println("Goodbye!");
                    PersonService.saveDatabase();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static void handleGet(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Error: Missing ID for GET command.");
            return;
        }
        int id = Integer.parseInt(parts[1]);
        Person person = PersonService.getPersonById(id);
        if (person == null) {
            System.out.println("Person not found with ID: " + id);
        } else {
            System.out.println(person);
        }
    }

    private static void handlePostUsingSetters(Scanner scanner) {
        PersonService.addPersonUsingSetters(scanner);
    }

    private static void handleDelete(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Error: Missing ID for DELETE command.");
            return;
        }
        int id = Integer.parseInt(parts[1]);
        if (PersonService.deletePersonById(id)) {
            System.out.println("Person deleted with ID: " + id);
        } else {
            System.out.println("Person not found with ID: " + id);
        }
    }

    private static void handlePrint() {
        Collection<Person> people = PersonService.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("No people found in the database.");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }
}