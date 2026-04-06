package ordersystem.model;

import java.util.Objects;

public class Address {

    private final String street;
    private final String city;
    private final String state;
    private final String country;
    private final int zipCode;

    public Address(String street, String city, String state, String country, int zipCode) {
        this.street = validateText(street, "Street");
        this.city = validateText(city, "City");
        this.state = validateText(state, "State");
        this.country = validateText(country, "Country");
        this.zipCode = validateZipCode(zipCode);
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getCountry() { return country; }
    public int getZipCode() { return zipCode; }

    private static String validateText(String value, String fieldName) {
        Objects.requireNonNull(value, fieldName + " cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
        return value;
    }

    private static int validateZipCode(int zipCode) {
        if (zipCode <= 0) {
            throw new IllegalArgumentException("Zip code must be positive");
        }
        if (zipCode > 65535) {
            throw new IllegalArgumentException("Zip code must be less than 65535");
        }
        return zipCode;
    }
}