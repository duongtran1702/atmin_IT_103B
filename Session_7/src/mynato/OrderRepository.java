package mynato;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private final Map<String, Order> orders;

    public OrderRepository() {
        orders = new HashMap<>();
    }

    public void save(Order order) {
        orders.put(order.id, order);
        System.out.printf("Đã lưu đơn hàng %s\n", order.id);
    }

    public Order findById(String id) {
        return orders.get(id);
    }
}
