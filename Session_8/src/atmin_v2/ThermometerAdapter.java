package atmin_v2;

public class ThermometerAdapter implements TemperatureSensor {
    private final OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        int temp = oldThermometer.getTemperatureFahrenheit();
        double c = (temp - 32) * 5.0 / 9;
        return Math.round(c * 10.0) / 10.0;
    }
}

class NewThermometer implements TemperatureSensor {
    public double getTemperatureCelsius() {
        return 25.5;
    }
}