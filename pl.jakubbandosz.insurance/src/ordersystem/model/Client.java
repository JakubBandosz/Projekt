package ordersystem.model;

import java.util.UUID;
import java.time.LocalDate;
import java.time.Period;

public class Client {

    private final UUID id;
    private final String name;
    private final String surname;
    private final LocalDate birthDate;
    private final String address;

    public Client(String name, String surname, LocalDate birthDate, String address) {
        this(UUID.randomUUID(), name, surname, birthDate, address);
    }

    private Client(UUID id, String name, String surname, LocalDate birthDate, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getAddress() { return address; }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public Client withAddress(String newAddress) {
        if (newAddress == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        return new Client(this.id, this.name, this.surname, this.birthDate, newAddress);
    }

    public Client withSurname(String newSurname) {
        if (newSurname == null) {
            throw new IllegalArgumentException("Surname cannot be null");
        }
        return new Client(this.id, this.name, newSurname, this.birthDate, this.address);
    }

    public Client withBirthDate(LocalDate newBirthDate) {
        if (newBirthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        return new Client(this.id, this.name, this.surname, newBirthDate, this.address);
    }
}
