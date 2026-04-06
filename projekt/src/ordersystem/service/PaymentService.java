package ordersystem.service;

import ordersystem.model.*;

public class PaymentService {

    public Payment processPayment(Payment payment) {


        boolean success = Math.random() > 0.3;

        if (success) {
            return payment.withStatus(PaymentStatus.PAID);
        } else {
            return payment.withStatus(PaymentStatus.FAILED);
        }
    }
}