package mynato_ver2;

public class Main {
    public static void main(String[] args) {

        double total = 1000000;

        OrderCalculator order1 =
                new OrderCalculator(new PercentageDiscount(10));
        System.out.println(order1.calculateTotal(total));

        OrderCalculator order2 =
                new OrderCalculator(new FixedDiscount(50000));
        System.out.println(order2.calculateTotal(total));

        OrderCalculator order3 =
                new OrderCalculator(new NoDiscount());
        System.out.println(order3.calculateTotal(total));

        OrderCalculator order4 =
                new OrderCalculator(new HolidayDiscount());
        System.out.println(order4.calculateTotal(total));
    }
}
