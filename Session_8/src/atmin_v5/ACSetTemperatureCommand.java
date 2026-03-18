package atmin_v5;

import atmin_v3.Command;
import atmin_v4.Observer;

class ACSetTemperatureCommand implements Command, Observer {
    private final AirConditioner ac;
    private int prevTemp;
    private final int newTemp;

    @Override
    public void update(int temperature) {
        System.out.println("Điều hòa: Nhiệt độ " + ac.getTemp() + "°C");
    }

    public ACSetTemperatureCommand(AirConditioner ac, int newTemp) {
        this.ac = ac;
        this.newTemp = newTemp;
    }

    @Override
    public void execute() {
        prevTemp = ac.getTemp();
        ac.setTemp(newTemp);
    }

    @Override
    public void undo() {
        ac.setTemp(prevTemp);
    }

}


