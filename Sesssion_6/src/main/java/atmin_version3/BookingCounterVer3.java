package atmin_version3;



import java.util.Random;

public class BookingCounterVer3 implements Runnable {

    String counterName;
    final TicketPoolVer3 roomA;
    final TicketPoolVer3 roomB;

    int soldCount = 0;

    Random rand = new Random();

    public BookingCounterVer3(String name, TicketPoolVer3 a, TicketPoolVer3 b) {

        counterName = name;
        roomA = a;
        roomB = b;
    }

    public void run() {

        while (TicketSupplierVer3.roundTemp > 0
                || roomA.remainingTickets() > 0
                || roomB.remainingTickets() > 0) {

            boolean success = sellCombo();

            if (!success) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean sellCombo() {

        TicketPoolVer3 first = roomA;
        TicketPoolVer3 second = roomB;

        synchronized (first) {

            synchronized (second) {

                if (roomA.remainingTickets() > 0 && roomB.remainingTickets() > 0) {

                    TicketVer3 a = roomA.sellTicket();
                    TicketVer3 b = roomB.sellTicket();

                    soldCount++;

                    TablePrinterVer3.printRow(
                            counterName + " bán COMBO",
                            counterName + " đã bán " + a.ticketId + " + " + b.ticketId
                    );

                    return true;
                }

                return false;
            }
        }
    }
}