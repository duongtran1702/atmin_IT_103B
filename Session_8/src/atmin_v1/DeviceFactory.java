package atmin_v1;

public abstract class DeviceFactory {
    abstract public Device createDevice();
}

class LightFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new Light();
    }
}

class FanFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new Fan();
    }
}

class AirConditionerFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new AirConditioner();
    }
}