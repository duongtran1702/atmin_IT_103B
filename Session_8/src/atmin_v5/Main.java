package atmin_v5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        ACSetTemperatureCommand acsc = new ACSetTemperatureCommand(new AirConditioner(), 28);

        TemperatureSensor ts = new TemperatureSensor();
        ts.attach(fan);
        ts.attach(acsc);

        SleepModeCommand smc = new SleepModeCommand(List.of(light, fan, acsc));
        smc.execute();
        ts.setTemp(28);

        ts.setTemp(32);
    }
}
