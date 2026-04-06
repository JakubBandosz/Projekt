package ordersystem.model;

import java.util.Objects;
import java.util.UUID;

public class FragileProduct extends Product {

    private static final double SHIPPING_RATE_PER_KG = 5.0;

    private final double weight;

    public FragileProduct(String name, double price, double weight) {
        super(UUID.randomUUID(), validateName(name), validatePrice(price));
        this.weight = validateWeight(weight);
    }

    @Override
    public double calculateShippingCost() {
        return weight * SHIPPING_RATE_PER_KG;
    }

    public double getWeight() {
        return weight;
    }

    private static double validateWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        return weight;
    }

    private static String validateName(String name) {
        Objects.requireNonNull(name, "Product name cannot be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        return name;
    }

    private static double validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        return price;
    }
}