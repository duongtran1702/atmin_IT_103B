package atmin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class B4 {

    public static void saveToFile() throws IOException {
        throw new IOException("Loi khi ghi file!");
    }

    public static void processUserData() throws IOException {
        saveToFile();
    }

    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = LocalDateTime.now().format(formatter);
            System.out.println("[ERROR] " + time);
        }
    }

}
