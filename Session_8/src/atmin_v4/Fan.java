package atmin_v4;

public class Fan implements Observer {
    @Override
    public void update(int temperature) {
        if (temperature < 20) {
            System.out.println("Fan: Tắt");
        } else if (temperature <= 25) {
            System.out.println("Fan: Chạy trung bình");
        } else {
            System.out.println("Fan: Chạy mạnh");
        }
    }
}
