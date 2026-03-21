package ordersystem.service;

import ordersystem.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {


    public Order createOrder(Client client, List<OrderItem> items) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        return new Order(
                client,
                items,
                LocalDate.now(),
                OrderStatus.NEW
        );
    }



    public double calculateShipping(Order order) {
        return order.getItems().stream()
                .mapToDouble(item -> item.getProduct().calculateShippingCost())
                .sum();
    }


    public double calculateFinalPrice(Order order) {
        return order.calculateTotalPrice()+(calculateShipping(order));
    }


    public Order changeStatus(Order order, OrderStatus newStatus) {
        if (order == null || newStatus == null) {
            throw new IllegalArgumentException("Order or status cannot be null");
        }
        return order.withStatus(newStatus);
    }


    public Order cancelOrder(Order order) {
        if (order.getStatus() == OrderStatus.SHIPPED) {
            throw new IllegalStateException("Cannot cancel shipped order");
        }
        return order.withStatus(OrderStatus.CANCELLED);
    }


    public Order addItem(Order order, OrderItem newItem) {
        List<OrderItem> updatedItems = new ArrayList<>(order.getItems());
        updatedItems.add(newItem);

        return new Order(
                order.getClient(),
                updatedItems,
                order.getOrderDate(),
                order.getStatus()
        );
    }


    public Order removeItem(Order order, UUID productId) {
        List<OrderItem> updatedItems = order.getItems().stream()
                .filter(item -> !item.getProduct().getId().equals(productId))
                .toList();

        return new Order(
                order.getClient(),
                updatedItems,
                order.getOrderDate(),
                order.getStatus()
        );
    }

    public double applyDiscount(Order order, double discountPercent) {
        if (discountPercent < 0 || discountPercent > 1) {
            throw new IllegalArgumentException("Discount must be between 0 and 1");
        }

        double total = calculateFinalPrice(order);
        double discount = total * discountPercent;

        return total - discount;
    }
}