package atmin_v4;

public class Humidifier implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Humidifier: Điều chỉnh độ ẩm theo nhiệt độ " + temperature + "°C");
    }
}
