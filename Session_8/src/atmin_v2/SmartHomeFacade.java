package atmin_v2;

public class SmartHomeFacade {
    private final TemperatureSensor thermometer;

    public SmartHomeFacade(TemperatureSensor thermometer) {
        this.thermometer = thermometer;
    }

    public double getCurrentTemperature() {
        return thermometer.getTemperatureCelsius();
    }

    public void leaveHome() {
        System.out.println("""
                FACADE: Tắt đèn
                FACADE: Tắt quạt
                FACADE: Tắt điều hòa""");
    }

    public void sleepMode() {
        System.out.println("""
                FACADE: Tắt đèn
                FACADE: Điều hòa set 28°C
                FACADE: Quạt chạy tốc độ thấp""");
    }
}
