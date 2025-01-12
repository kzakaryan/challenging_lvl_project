import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exception.InvalidPersonDataException;
import exception.PersonNotFoundException;
import model.Address;
import model.Contact;
import model.Gender;
import model.Person;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class PersonService {

    private static final String DATABASE_FILE = "person_database.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static Map<Integer, Person> database = new HashMap<>();
    private static int currentId = 1;

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static void loadDatabase() {
        File file = new File(DATABASE_FILE);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Person person = objectMapper.readValue(line, Person.class);
                database.put(person.getId(), person);
                currentId = Math.max(currentId, person.getId() + 1);
            }
        } catch (IOException e) {
            System.out.println("Error loading database: " + e.getMessage());
        }
    }

    public static void saveDatabase() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            for (Person person : database.values()) {
                writer.write(objectMapper.writeValueAsString(person));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving database: " + e.getMessage());
        }
    }

    public static void addPerson(Person person) {
        if (person == null) {
            throw new InvalidPersonDataException("Person data cannot be null");
        }
        person.setId(currentId++);
        database.put(person.getId(), person);
        saveDatabase();
    }

    public static void addPersonUsingSetters(Scanner scanner) {
        Person person = new Person();

        System.out.print("Enter first name: ");
        person.setFirstName(scanner.nextLine());

        System.out.print("Enter last name: ");
        person.setLastName(scanner.nextLine());

        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        person.setDateOfBirth(LocalDate.parse(scanner.nextLine()));

        Address address = new Address();
        System.out.print("Enter street: ");
        address.setStreet(scanner.nextLine());
        System.out.print("Enter city: ");
        address.setCity(scanner.nextLine());
        System.out.print("Enter state: ");
        address.setState(scanner.nextLine());
        System.out.print("Enter zip code: ");
        address.setZipCode(scanner.nextLine());
        System.out.print("Enter country: ");
        address.setCountry(scanner.nextLine());
        person.setAddress(address);

        List<Contact> contacts = new ArrayList<>();
        boolean addMoreContacts = true;
        while (addMoreContacts) {
            Contact contact = new Contact();
            System.out.print("Enter contact type (e.g., email, phone): ");
            contact.setType(scanner.nextLine());
            System.out.print("Enter contact value: ");
            contact.setValue(scanner.nextLine());
            contacts.add(contact);

            System.out.print("Do you want to add another contact? (yes/no): ");
            addMoreContacts = scanner.nextLine().equalsIgnoreCase("yes");
        }
        person.setContacts(contacts);

        System.out.print("Enter gender (MALE/FEMALE): ");
        person.setGender(Gender.valueOf(scanner.nextLine().toUpperCase()));

        System.out.print("Is the person active? (true/false): ");
        person.setActive(Boolean.parseBoolean(scanner.nextLine()));

        person.setId(currentId++);
        database.put(person.getId(), person);

        saveDatabase();

        System.out.println("Person added successfully: " + person);
    }

    public static Person getPersonById(int id) {
        if (!database.containsKey(id)) {
            throw new PersonNotFoundException("Person not found with ID: " + id);
        }
        return database.get(id);
    }

    public static boolean deletePersonById(int id) {
        if (!database.containsKey(id)) {
            throw new PersonNotFoundException("Person not found with ID: " + id);
        }
        database.remove(id);
        saveDatabase();
        return true;
    }

    public static Collection<Person> getAllPeople() {
        return database.values();
    }
}