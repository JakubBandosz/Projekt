package ordersystem.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.time.LocalDate;

public class Order {

    private final UUID orderId;
    private final Client client;
    private final List<OrderItem> items;
    private final LocalDate orderDate;
    private final OrderStatus status;

    public Order(Client client, List<OrderItem> items, LocalDate orderDate, OrderStatus status) {
        this(UUID.randomUUID(), client, items, orderDate, status);
    }

    private Order(UUID orderId, Client client, List<OrderItem> items, LocalDate orderDate, OrderStatus status) {
        this.orderId = Objects.requireNonNull(orderId, "Id cannot be null");
        this.client = Objects.requireNonNull(client, "Client cannot be null");
        this.items = List.copyOf(validateItems(items));
        this.orderDate = Objects.requireNonNull(orderDate, "Order date cannot be null");
        this.status = Objects.requireNonNull(status, "Status cannot be null");
    }

    public UUID getOrderId() {
        return orderId;
    }

    public Client getClient() {
        return client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    public Order withStatus(OrderStatus newStatus) {
        Objects.requireNonNull(newStatus, "Status cannot be null");
        return new Order(this.orderId, this.client, this.items, this.orderDate, newStatus);
    }

    public Order withItems(List<OrderItem> newItems) {
        return new Order(this.orderId, this.client, newItems, this.orderDate, this.status);
    }

    public Order withOrderDate(LocalDate newDate) {
        Objects.requireNonNull(newDate, "Order date cannot be null");
        return new Order(this.orderId, this.client, this.items, newDate, this.status);
    }

    private static List<OrderItem> validateItems(List<OrderItem> items) {
        Objects.requireNonNull(items, "Items cannot be null");
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", client=" + client +
                ", items=" + items +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }
}