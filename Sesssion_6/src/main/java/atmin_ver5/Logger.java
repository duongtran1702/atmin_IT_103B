package atmin_ver5;

class Logger {

    static long startTime = System.currentTimeMillis();

    public static synchronized void log(String action, String output) {

        long now = System.currentTimeMillis();
        long t = (now - startTime) / 1000;

        System.out.printf(
                "t = %-3ds | %-30s | %-50s\n",
                t,
                action,
                output
        );
    }

    public static void printHeader() {
        System.out.printf("%-10s | %-30s | %-50s\n",
                "Thời điểm", "Hành động", "Output");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
