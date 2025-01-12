package model;

import java.util.List;
import java.time.LocalDate;

/**
 * model.Person class to keep record for people in the database
 */
public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Address address;
    private List<Contact> contacts;
    private Gender gender;
    private boolean isActive;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"id\": %d,\n" +
                        "  \"firstName\": \"%s\",\n" +
                        "  \"lastName\": \"%s\",\n" +
                        "  \"dateOfBirth\": \"%s\",\n" +
                        "  \"address\": %s,\n" +
                        "  \"contacts\": %s,\n" +
                        "  \"gender\": \"%s\",\n" +
                        "  \"isActive\": %b\n" +
                        "}",
                id, firstName, lastName, dateOfBirth, address, contacts, gender, isActive
        );
    }
}