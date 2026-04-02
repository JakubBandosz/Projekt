import ordersystem.model.*;
import ordersystem.repository.*;
import ordersystem.service.OrderService;
import ordersystem.service.PaymentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        ProductRepository productRepo = new ProductRepository();
        OrderRepository orderRepo = new OrderRepository();
        PaymentRepository paymentRepo = new PaymentRepository();

        Address address = new Address(
                "Swietojanska",
                "Bialystok",
                "Podlaskie",
                "Poland",
                15082
        );

        Client client = new Client(
                "Jakub",
                "Bandosz",
                LocalDate.of(2004, 2, 11),
                address
        );

        Product product1 = new PhysicalProduct("Laptop", 2500.0, 2);
        Product product2 = new FragileProduct("Monitor", 800.0, 1);

        productRepo.save(product1);
        productRepo.save(product2);

        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(product1, 1));
        items.add(new OrderItem(product2, 2));

        Order order = orderService.createOrder(client, items);
        orderRepo.save(order);

        double finalPrice = orderService.applyDiscount(order, 0.1);

        Payment payment = new Payment(order, finalPrice);
        payment = paymentService.processPayment(payment);
        paymentRepo.save(payment);

        if (payment.getStatus() == PaymentStatus.PAID) {
            order = orderService.changeStatus(order, OrderStatus.PAID);
        } else {
            order = orderService.cancelOrder(order);
        }

        orderRepo.save(order);

        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Final price: " + finalPrice);
        System.out.println("Payment status: " + payment.getStatus());
        System.out.println("Order status: " + order.getStatus());

        System.out.println("\nOrders in repository:");
        orderRepo.findAll().forEach(System.out::println);

        System.out.println("\nPayments in repository:");
        paymentRepo.findAll().forEach(System.out::println);

        System.out.println("\nProducts in repository:");
        productRepo.findAll().forEach(System.out::println);
    }
}