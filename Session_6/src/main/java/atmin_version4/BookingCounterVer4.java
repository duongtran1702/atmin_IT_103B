package atmin_version4;

import java.util.Random;

public class BookingCounterVer4 implements Runnable {

    String counterName;
    final TicketPoolVer4 roomA;
    final TicketPoolVer4 roomB;

    public int soldCount = 0;
    Random rand = new Random();

    public BookingCounterVer4(String name, TicketPoolVer4 a, TicketPoolVer4 b) {

        counterName = name;
        roomA = a;
        roomB = b;
    }

    public void run() {

        while (TicketSupplierVer4.roundTemp > 0
                || roomA.remainingTickets() > 0
                || roomB.remainingTickets() > 0) {

            boolean chooseA = rand.nextBoolean();
            TicketVer4 ticketVer4;

            if (chooseA) {
                ticketVer4 = roomA.sellTicket();
                if (ticketVer4 != null) {
                    soldCount++;
                    TablePrinterVer4.printRow(
                            counterName + " bán vé phòng A",
                            counterName + " đã bán vé " + ticketVer4.ticketId
                    );
                }
            } else {

                ticketVer4 = roomB.sellTicket();
                if (ticketVer4 != null) {
                    soldCount++;
                    TablePrinterVer4.printRow(
                            counterName + " bán vé phòng B",
                            counterName + " đã bán vé " + ticketVer4.ticketId
                    );
                }
            }

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}