package ordersystem.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Payment {

    private final UUID id;
    private final Order order;
    private final double amount;
    private final PaymentStatus status;
    private final LocalDateTime createdAt;

    public Payment(Order order, double amount) {
        this(
                UUID.randomUUID(),
                order,
                amount,
                PaymentStatus.PENDING,
                LocalDateTime.now()
        );
    }

    private Payment(UUID id, Order order, double amount, PaymentStatus status, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id);
        this.order = Objects.requireNonNull(order);
        this.amount = amount;
        this.status = Objects.requireNonNull(status);
        this.createdAt = Objects.requireNonNull(createdAt);
    }

    public Payment withStatus(PaymentStatus newStatus) {
        return new Payment(
                this.id,
                this.order,
                this.amount,
                newStatus,
                this.createdAt
        );
    }



    public UUID getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}