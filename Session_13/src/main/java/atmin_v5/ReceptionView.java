// ReceptionView.java
package atmin_v5;

import java.util.List;
import java.util.Scanner;

public class ReceptionView {
    private final ReceptionController controller = new ReceptionController();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem giường trống");
            System.out.println("2. Tiếp nhận bệnh nhân");
            System.out.println("3. Thoát");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showAvailableBeds();
                    break;
                case "2":
                    handleAdmit();
                    break;
                case "3":
                    System.out.println("Thoát...");
                    return;
                default:
                    System.out.println("Chọn sai!");
            }
        }
    }

    private void showAvailableBeds() {
        List<Integer> beds = controller.getAvailableBeds();

        if (beds.isEmpty()) {
            System.out.println("Không có giường trống");
        } else {
            System.out.println("Giường trống:");
            for (int bed : beds) {
                System.out.println("- Bed ID: " + bed);
            }
        }
    }

    private void handleAdmit() {
        try {
            System.out.print("Tên: ");
            String name = sc.nextLine();

            System.out.print("Tuổi: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Mã giường: ");
            int bedId = Integer.parseInt(sc.nextLine());

            System.out.print("Tiền tạm ứng: ");
            double money = Double.parseDouble(sc.nextLine());

            controller.admitPatient(name, age, bedId, money);

        } catch (Exception e) {
            System.out.println("Input không hợp lệ!");
        }
    }
}