package atmin_v3;

public class Main {
    public static void main(String[] args) {

        RemoteControl rc1 = new RemoteControl(new LightOnCommand());
        rc1.press();

        RemoteControl rc2 = new RemoteControl(new LightOffCommand());
        rc2.press();
        rc2.pressUndo();

        RemoteControl rc3 = new RemoteControl(new ACSetTemperatureCommand(new AirConditioner(25),26));
        rc3.press();
        rc3.pressUndo();
    }
}
