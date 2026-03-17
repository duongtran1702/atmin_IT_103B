package mynato;

public class Customer {
    String name;
    String email;
    String address;

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
        System.out.println("Đã tạo khách hàng mới.");
    }
}
