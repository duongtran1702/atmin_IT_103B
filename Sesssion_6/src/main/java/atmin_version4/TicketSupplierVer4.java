package atmin_version4;

import atmin.TablePrinter;
import atmin.TicketPool;

public class TicketSupplierVer4 implements Runnable {
    TicketPoolVer4 roomA;
    TicketPoolVer4 roomB;
    int supplyCount;
    int interval;
    int rounds;
    public static volatile int roundTemp;

    public TicketSupplierVer4(TicketPoolVer4 roomA, TicketPoolVer4 roomB, int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
        roundTemp = rounds;
    }

    @Override
    public void run() {

        for (int i = 1; i <= rounds; i++) {

            try {
                Thread.sleep(interval);
                roundTemp--;
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            roomA.addTickets(supplyCount);
            TablePrinterVer4.printRow("(Sau 3 giây)", "Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng A");

            roomB.addTickets(supplyCount);
            TablePrinterVer4.printRow("", "Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng B");
        }
    }

}
