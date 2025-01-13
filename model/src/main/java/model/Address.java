package model;

import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.Serializable;

/**
 * Class to keep track of geographical location of people
 */
public class Address implements Serializable {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address () {}

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

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
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