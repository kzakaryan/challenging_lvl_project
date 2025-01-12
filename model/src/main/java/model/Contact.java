package model;

/**
 * Class to keep record of Contacts of model.Person
 */
public class Contact {

    private String type;
    private String value;

    public void setType(String type) {
        this.type = type;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"type\": \"%s\",\n" +
                        "  \"value\": \"%s\"\n" +
                        "}",
                type, value
        );
    }
}