package atmin_v1;

public class HardwareConnection {
    private HardwareConnection() {
        System.out.println("Đã kết nối phần cứng");
    }

    private static class Holder {
        private static final HardwareConnection INSTANCE = new HardwareConnection();
    }

    public static HardwareConnection getInstance() {
        return Holder.INSTANCE;
    }

    public void connect(String deviceName) {
        System.out.println("Connect to " + deviceName);
    }

    public void disconnect(String deviceName) {
        System.out.println("Disconnect from " + deviceName);
    }
}
