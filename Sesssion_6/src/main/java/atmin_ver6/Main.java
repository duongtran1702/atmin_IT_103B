package atmin_ver6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CinemaSystem system = new CinemaSystem();

        while (true) {

            System.out.println("""
1. Bắt đầu mô phỏng
2. Tạm dừng mô phỏng
3. Tiếp tục mô phỏng
4. Thêm vé
5. Xem thống kê
6. Phát hiện deadlock
7. Thoát
""");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {

                    System.out.print("Số phòng: ");
                    int rooms = sc.nextInt();

                    System.out.print("Số vé/phòng: ");
                    int tickets = sc.nextInt();

                    System.out.print("Số quầy: ");
                    int counters = sc.nextInt();

                    system.start(rooms, tickets, counters);
                }

                case 2 -> system.pause();

                case 5 -> system.stats();

                case 6 -> new Thread(new DeadlockDetector()).start();

                case 7 -> {
                    System.out.println("Đang dừng hệ thống...");
                    System.exit(0);
                }
            }
        }
    }
}
