package atmin_v5;

import atmin_v3.Command;
import atmin_v4.Observer;

public class Fan implements Observer, Command {
    int temperature;

    @Override
    public void update(int temp) {
        this.temperature = temp;
        if (temperature < 20) {
            System.out.println("Fan: Quạt tắt");
        } else if (temperature <= 28) {
            System.out.println("Fan: Chạy tốc độ thấp");
        } else {
            System.out.println("Fan: Chạy tốc độ mạnh");
        }
    }

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
