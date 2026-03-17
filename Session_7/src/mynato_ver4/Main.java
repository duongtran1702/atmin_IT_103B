package mynato_ver4;

public class Main {

    public static void main(String[] args) {

        // Cấu hình 1
        OrderService service1 =
                new OrderService(
                        new FileOrderRepository(),
                        new EmailService()
                );

        service1.createOrder(new Order("ORD001"));


        System.out.println();


        // Cấu hình 2
        OrderService service2 =
                new OrderService(
                        new DatabaseOrderRepository(),
                        new SMSNotification()
                );

        service2.createOrder(new Order("ORD002"));
    }
}
