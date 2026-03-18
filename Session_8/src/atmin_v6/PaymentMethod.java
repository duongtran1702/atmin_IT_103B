package atmin_v6;

// PaymentMethod
public interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán thẻ tín dụng: " + amount);
    }
}

class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán MoMo: " + amount);
    }
}

class CODPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán khi nhận hàng: " + amount);
    }
}
