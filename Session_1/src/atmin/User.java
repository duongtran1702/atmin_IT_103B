package atmin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    int age;

    public void setAge(int age) {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am!", 1001);
        }
        this.age = age;
    }

    public static void main(String[] args) {
        User a = new User();
        try {
            a.setAge(-18);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String time = LocalDateTime.now().format(formatter);
            System.out.println("[ERROR] " + time );
        }
    }

}
