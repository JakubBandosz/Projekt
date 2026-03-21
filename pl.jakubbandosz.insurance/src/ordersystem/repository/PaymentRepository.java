package ordersystem.repository;
import ordersystem.model.Payment;
import java.util.*;
public class PaymentRepository {

    private final Map<UUID, Payment> payments = new HashMap<>();

    public void save(Payment payment) {
        payments.put(payment.getId(), payment);
    }
}