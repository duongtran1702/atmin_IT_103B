package atmin_v3;

public interface Command {
    void execute();

    void undo();
}

class LightOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Light on");
    }

    @Override
    public void undo() {
        System.out.println("Light off");
    }
}

class LightOffCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Light off");
    }

    @Override
    public void undo() {
        System.out.println("Light on");
    }
}

class FanOnCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Fan on");
    }

    @Override
    public void undo() {
        System.out.println("Fan off");
    }
}

class FanOffCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Fan off");
    }

    @Override
    public void undo() {
        System.out.println("Fan on");
    }
}

class AirConditioner {
    private int temp;

    public AirConditioner(int temp) {
        this.temp = temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
        System.out.println("Temperature current = " + temp + "°C");
    }

    public int getTemp() {
        return temp;
    }

}

class ACSetTemperatureCommand implements Command {
    private final AirConditioner ac;
    private int prevTemp;
    private final int newTemp;

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


