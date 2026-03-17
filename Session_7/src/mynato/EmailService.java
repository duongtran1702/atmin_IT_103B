package mynato;

public class EmailService {
    public EmailService() {
    }

    public void sendOrderConfirmation(Customer customer, Order order) {
        System.out.println("Sending email to: " + customer.email);
        System.out.println("Order ID: " + order.id);
        System.out.println("Order confirmed!");
    }
}