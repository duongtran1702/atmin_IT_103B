package atmin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String year = sc.nextLine();
            int yearInt = Integer.parseInt(year);
            System.out.println("Nam sinh: " + yearInt);
        } catch (NumberFormatException e) {
            System.out.println("Năm sinh không hợp lệ !");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = LocalDateTime.now().format(formatter);

            System.out.println("[ERROR] " + time + " - " + e.getMessage());
        } finally {
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }
}
