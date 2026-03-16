package atmin_version2;

import atmin.TablePrinter;
import atmin.TicketPool;

public class TicketSupplier implements Runnable {
    TicketPool roomA;
    TicketPool roomB;
    int supplyCount;
    int interval;
    int rounds;
    public static int roundTemp;

    public TicketSupplier(TicketPool roomA, TicketPool roomB, int supplyCount, int interval, int rounds) {
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
            TablePrinter.printRow("(Sau 3 giây)", "Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng A");

            roomB.addTickets(supplyCount);
            TablePrinter.printRow("", "Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng B");
        }
    }

}
