package ordersystem.model;

import java.util.UUID;


public class StandardProduct extends Product {

    private static final double SHIPPING_RATE_PER_KG = 2.0;

    private final double weight;

    public StandardProduct(String name, double price, double weight) {
        super(UUID.randomUUID(), name, price);
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
}