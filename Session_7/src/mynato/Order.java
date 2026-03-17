package mynato;

import java.util.List;
import java.util.UUID;

public class Order {
    String id;
    Customer customer;
    List<OrderItem> items;

    public Order(Customer customer, List<OrderItem> items) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.customer = customer;
        this.items = items;
        System.out.printf("Đã tạo đơn hàng %s.\n",id);
    }

    public void addProduct(OrderItem item) {
        this.items.add(item);

    }

    public List<OrderItem> getItems() {
        return items;
    }

}
