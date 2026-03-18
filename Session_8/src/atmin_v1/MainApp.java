package atmin_v1;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HardwareConnection connection = null;
        Device device = null;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    if (connection == null) {
                        connection = HardwareConnection.getInstance();
                    } else System.out.println("Không thể kết nối lại phần cứng");
                    break;

                case 2:
                    System.out.println("Chọn loại thiết bị:");
                    System.out.println("1. Light");
                    System.out.println("2. Fan");
                    System.out.println("3. AirConditioner");
                    System.out.print("Chọn: ");

                    int type = scanner.nextInt();
                    scanner.nextLine();

                    DeviceFactory factory;
                    String nameDevice;

                    switch (type) {
                        case 1:
                            factory = new LightFactory();
                            nameDevice = "Light";
                            break;
                        case 2:
                            factory = new FanFactory();
                            nameDevice = "Fan";
                            break;
                        case 3:
                            factory = new AirConditionerFactory();
                            nameDevice = "Air Conditioner";
                            break;
                        default:
                            System.out.println("Loại không hợp lệ!");
                            continue;
                    }

                    device = factory.createDevice();

                    if (connection != null) {
                        connection.connect(nameDevice);
                    } else {
                        System.out.println("Chưa kết nối phần cứng!");
                    }
                    break;

                case 3:
                    if (device != null) {
                        device.turnOn();
                    } else {
                        System.out.println("⚠ Chưa có thiết bị!");
                    }
                    break;

                case 4:
                    if (device != null) {
                        device.turnOff();
                    } else {
                        System.out.println("⚠ Chưa có thiết bị!");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}