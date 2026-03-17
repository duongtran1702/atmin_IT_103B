package mynato_ver2;

public class PercentageDiscount implements DiscountStrategy {

    private final double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * (1 - percent / 100);
    }
}
