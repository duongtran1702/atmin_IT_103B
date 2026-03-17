package mynato;

public class Product {
    String id;
    String name;
    double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        System.out.printf("Đã thêm sản phẩm %s.\n",id);
    }
}
