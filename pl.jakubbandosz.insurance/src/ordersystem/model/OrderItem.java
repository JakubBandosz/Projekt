package ordersystem.model;

import java.util.Objects;
import java.util.UUID;

public class OrderItem {

    private final UUID orderItemId;
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        this(UUID.randomUUID(), product, quantity);
    }

    private OrderItem(UUID orderItemId, Product product, int quantity) {
        this.orderItemId = Objects.requireNonNull(orderItemId, "Id cannot be null");
        this.product = Objects.requireNonNull(product, "Product cannot be null");
        this.quantity = validateQuantity(quantity);
    }

    public UUID getOrderItemId() {
        return orderItemId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public OrderItem withQuantity(int newQuantity) {
        return new OrderItem(this.orderItemId, this.product, newQuantity);
    }

    private static int validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}