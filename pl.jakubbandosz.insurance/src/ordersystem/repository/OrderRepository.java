package ordersystem.repository;
import ordersystem.model.Order;
import java.util.*;
public class OrderRepository {

    private final Map<UUID, Order> orders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Order findById(UUID id) {
        return orders.get(id);
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }
}