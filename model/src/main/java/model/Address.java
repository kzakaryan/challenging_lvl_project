package model;

/**
 * Class to keep track of geographical location of people
 */
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format(
                "{\n" +
                        "  \"street\": \"%s\",\n" +
                        "  \"city\": \"%s\",\n" +
                        "  \"state\": \"%s\",\n" +
                        "  \"zipCode\": \"%s\",\n" +
                        "  \"country\": \"%s\"\n" +
                        "}",
                street, city, state, zipCode, country
        );
    }
}