package atmin_v1;

public interface Device {
    void turnOn();

    void turnOff();
}

class Light implements Device {
    @Override
    public void turnOff() {
        System.out.println("Turn off light");
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on light");
    }
}

class Fan implements Device {
    @Override
    public void turnOff() {
        System.out.println("Turn off fan");
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on fan");
    }
}

class AirConditioner implements Device {
    @Override
    public void turnOn() {
        System.out.println("Turn off air conditioner");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off air conditioner");
    }
}
