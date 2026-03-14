import ordersystem.model.Address;

import java.time.LocalDate;
import ordersystem.model.*;
import ordersystem.repository.*;
public class Main {

    public static void main(String[] args) {

        Address address1 = new Address(
                "Swietojanska",
                "Bialystok",
                "Podlaskie",
                "Poland",
                15082
        );

        Client client1 = new Client(
                "Jakub",
                "Bandosz",
                LocalDate.of(2004, 2, 11),
                address1
        );

        System.out.println(client1);
    }
}