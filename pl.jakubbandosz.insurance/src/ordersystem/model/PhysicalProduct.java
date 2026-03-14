package ordersystem.model;
import java.util.UUID;


public class PhysicalProduct extends Product {

    private final double weight;

    public PhysicalProduct(String name, double price, double weight) {
        super(UUID.randomUUID(), name, price);
        this.weight = weight;
    }

    @Override
    public double calculateShippingCost() {
        return weight * 2.0;
    }

    public double getWeight() {
        return weight;
    }
}