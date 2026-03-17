package mynato;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OrderCalculator {
    Order o;

    public OrderCalculator(Order o) {
        this.o = o;
    }

    public double calculatorTotal() {
        return o.items.stream()
                .mapToDouble(o->o.quantity*o.product.price)
                .sum();
    }

    public String formatMoney() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return nf.format(calculatorTotal());
    }
}
