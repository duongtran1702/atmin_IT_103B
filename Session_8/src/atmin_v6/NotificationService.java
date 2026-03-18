package atmin_v6;

// NotificationService
public interface NotificationService {
    void notifyUser(String message);
}

class EmailNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Gửi email: " + message);
    }
}

class PushNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}

class PrintReceipt implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("In hóa đơn: " + message);
    }
}