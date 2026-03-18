package atmin_v6;


public class OrderService {
    private DiscountStrategy discountStrategy;
    private PaymentMethod paymentMethod;
    private NotificationService notificationService;

    public OrderService(SalesChannelFactory factory) {
        this.discountStrategy = factory.createDiscountStrategy();
        this.paymentMethod = factory.createPaymentMethod();
        this.notificationService = factory.createNotificationService();
    }

    public void processOrder(String product, int quantity, double price) {
        double total = price * quantity;
        double finalPrice = discountStrategy.applyDiscount(total);

        System.out.println("Sản phẩm: " + product);
        System.out.println("Giá gốc: " + total);
        System.out.println("Sau giảm giá: " + finalPrice);

        paymentMethod.pay(finalPrice);
        notificationService.notifyUser("Đơn hàng thành công");
    }
}

class KioskFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }
}