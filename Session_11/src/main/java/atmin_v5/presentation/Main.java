package atmin_v5.presentation;

import atmin_v5.business.DoctorService;
import atmin_v5.model.Doctor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoctorService service = new DoctorService();

        while (true) {
            System.out.println("\n===== RIKKEI CARE =====");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    service.showAll();
                    break;

                case 2:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập họ tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập chuyên khoa: ");
                    String spec = sc.nextLine();

                    Doctor doctor = new Doctor(id, name, spec);
                    service.addDoctor(doctor);
                    break;

                case 3:
                    service.statistic();
                    break;

                case 4:
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println("Chọn sai!");
            }
        }
    }
}