package mynato_ver2;

public class OrderCalculator {

    // Chiến lược giảm giá
    private final DiscountStrategy discountStrategy;

    // Constructor nhận chiến lược giảm giá
    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // Tính tổng tiền sau khi giảm giá
    public double calculateTotal(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}