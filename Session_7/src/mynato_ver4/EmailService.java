package mynato_ver4;

public class EmailService implements NotificationService {

    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi Email: " + message);
    }
}
