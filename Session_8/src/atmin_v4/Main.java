package atmin_v4;

public class Main {

    public static void main(String[] args) {
        TemperatureSensor ts = new TemperatureSensor();
        ts.attach(new Humidifier());
        ts.attach(new Fan());
        System.out.println("""
                Quạt: Đã đăng ký nhận thông báo
                Máy tạo ẩm: Đã đăng ký""");

        ts.setTemp(18);
        ts.setTemp(20);
    }
}
