package atmin_v6;

// DiscountStrategy
public interface DiscountStrategy {
    double applyDiscount(double amount);
}

class WebsiteDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.9; // giảm 10%
    }
}

class FirstTimeDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.85; // giảm 15%
    }
}

class MemberDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.95; // giảm 5%
    }
}