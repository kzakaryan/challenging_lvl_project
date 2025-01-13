import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;
import java.util.*;

public class DatabaseControllerImpl {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void launch(Scanner scanner) {
        System.out.println("Welcome to the Terminal REST App (Person Management with File I/O)!");
        System.out.println("Available commands:");
        System.out.println("1. GET [id] - Retrieve a person by ID");
        System.out.println("2. POST [JSON] - Create a new person (in JSON format)");
        System.out.println("3. POST-SETTERS - Create a new person using setters");
        System.out.println("4. DELETE [id] - Delete a person by ID");
        System.out.println("5. PRINT - Print all people in JSON format");
        System.out.println("6. EXIT - Exit the application");
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
                case "POST":
                    handlePost(parts);
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
                    PersonService.saveDatabase(); // Save data before exiting
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

    private static void handlePost(String[] parts) {
        if (parts.length < 2) {
            System.out.println("Error: Missing JSON data for POST command.");
            return;
        }
        try {
            Person person = objectMapper.readValue(parts[1], Person.class);
            PersonService.addPerson(person);
            System.out.println("Person added successfully: " + person);
        } catch (Exception e) {
            System.out.println("Error: Invalid JSON format.");
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