package atmin_v6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SalesChannelFactory factory = null;

        System.out.println("Chọn kênh:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                break;
            case 2:
                factory = new MobileAppFactory();
                break;
            case 3:
                factory = new POSFactory();
                break;
            default:
                System.out.println("Không hợp lệ");
                return;
        }

        sc.nextLine(); // clear buffer

        System.out.print("Nhập tên sản phẩm: ");
        String product = sc.nextLine();

        System.out.print("Số lượng: ");
        int quantity = sc.nextInt();

        System.out.print("Giá: ");
        double price = sc.nextDouble();

        OrderService orderService = new OrderService(factory);
        orderService.processOrder(product, quantity, price);
    }
}
