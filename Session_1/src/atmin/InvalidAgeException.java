package atmin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InvalidAgeException extends RuntimeException {

    private final int eCode;

    public InvalidAgeException(String msg, int eCode) {
        super(msg);
        this.eCode = eCode;
    }

    public int geteCode() {
        return eCode;
    }

    public static void main(String[] args) {
        User a = new User();
        try {
            a.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Loi: " + e.getMessage());
            System.out.println("Ma loi: " + e.geteCode());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = LocalDateTime.now().format(formatter);

            System.out.println("[ERROR] " + time + " - " + e.getMessage());
        }
    }
}
