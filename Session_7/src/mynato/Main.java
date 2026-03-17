package mynato;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("SP1", "Laptop", 15000000);
        Product p2 = new Product("SP2", "Chuột ", 300000);

        Customer c = new Customer("Nguyen Van A", "a@gmail.com", "abc,ABC");

        OrderItem o1 = new OrderItem(p1, 1);
        OrderItem o2 = new OrderItem(p2, 2);

        List<OrderItem> items = new ArrayList<>(List.of(o1, o2));
        Order o = new Order(c, items);

        OrderCalculator calc = new OrderCalculator(o);
        System.out.println("Tổng tiền: " + calc.formatMoney());

        OrderRepository repo = new OrderRepository();
        repo.save(o);

        EmailService emailService = new EmailService();
        emailService.sendOrderConfirmation(c, o);
    }
}
