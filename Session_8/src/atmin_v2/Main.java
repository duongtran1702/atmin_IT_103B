package atmin_v2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OldThermometer oldThermometer = new OldThermometer(78);
        SmartHomeFacade smartHome = new SmartHomeFacade(new ThermometerAdapter(oldThermometer));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    ===== SMART HOME =====
                    1. Xem nhiệt độ
                    2. Rời nhà
                    3. Chế độ ngủ
                    0. Thoát
                    """);

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    double temp = smartHome.getCurrentTemperature();
                    System.out.println("Nhiệt độ hiện tại: " + temp + "°C");
                }
                case 2 -> smartHome.leaveHome();
                case 3 -> smartHome.sleepMode();
                case 0 -> {
                    System.out.println("Thoát...");
                    return;
                }
                default -> System.out.println("Chọn sai!");
            }
        }
    }
}