package atmin_b5.presentation;

import atmin_b5.business.PatientService;
import atmin_b5.dao.PatientDAO;
import atmin_b5.model.Patient;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();
        PatientService service = new PatientService();

        while (true) {
            System.out.println("\n=== HOSPITAL MANAGEMENT ===");
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Tiếp nhận bệnh nhân mới");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện & Tính phí");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        List<Patient> patients = dao.getAllPatients();
                        System.out.printf("| %-5s | %-20s | %-5s | %-15s | %-20s |\n",
                                "ID", "Tên", "Tuổi", "Khoa", "Bệnh lý");
                        for (Patient p : patients) {
                            String diseaseDisplay = p.getDisease() == null ? "-" : p.getDisease();
                            System.out.printf("| %-5s | %-20s | %-5s | %-15s | %-20s |\n",
                                    p.getId(),
                                    p.getName(),
                                    p.getAge(),
                                    p.getDepartment(),
                                    diseaseDisplay);
                            System.out.printf("| %-5s | %-20s | %-5s | %-15s | %-20s |\n",
                                    p.getId(),
                                    p.getName(),
                                    p.getAge(),
                                    p.getDepartment(),
                                    diseaseDisplay);
                        }
                        break;

                    case 2:
                        System.out.print("Tên bệnh nhân: ");
                        String name = sc.nextLine();
                        System.out.print("Tuổi: ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.print("Khoa: ");
                        String dept = sc.nextLine();
                        System.out.print("Bệnh lý: ");
                        String disease = sc.nextLine();

                        Patient newPatient = new Patient(0, name, age, dept, disease);

                        service.admitPatient(newPatient);
                        System.out.println("Bệnh nhân đã được tiếp nhận!");
                        break;

                    case 3:
                        System.out.print("Mã bệnh nhân cần cập nhật: ");
                        int idUpdate = Integer.parseInt(sc.nextLine());
                        System.out.print("Bệnh lý mới: ");
                        String newDisease = sc.nextLine();
                        boolean temp = dao.updateDisease(idUpdate, newDisease);
                        if (temp) {
                            System.out.println("Cập nhật bệnh án thành công!");
                        }
                        break;

                    case 4:
                        System.out.print("Mã bệnh nhân xuất viện: ");
                        int idDischarge = Integer.parseInt(sc.nextLine());
                        service.dischargePatient(idDischarge);
                        System.out.println("Xuất viện và tính phí xong!");
                        break;

                    case 5:
                        System.out.println("Thoát chương trình.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Chức năng không hợp lệ!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    }
}
