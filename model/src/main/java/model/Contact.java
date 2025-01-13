package model;

import java.io.Serializable;

/**
 * Class to keep record of Contacts of model.Person
 */
public class Contact implements Serializable {

    private String type;
    private String value;

    public void setType(String type) {
        this.type = type;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
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