package atmin;

import atmin_version2.TicketSupplier;

import java.util.Random;

public class BookingCounter implements Runnable {

    String counterName;
    final TicketPool roomA;
    final TicketPool roomB;

    public int soldCount = 0;

    Random rand = new Random();

    public BookingCounter(String name, TicketPool a, TicketPool b) {

        counterName = name;
        roomA = a;
        roomB = b;
    }

    public void run() {

        while (TicketSupplier.roundTemp > 0
                || roomA.remainingTickets() > 0
                || roomB.remainingTickets() > 0) {

            boolean chooseA = rand.nextBoolean();
            Ticket ticket;

            if (chooseA) {
                ticket = roomA.sellTicket();
                if (ticket != null) {
                    soldCount++;
                    TablePrinter.printRow(
                            counterName + " bán vé phòng A",
                            counterName + " đã bán vé " + ticket.ticketId
                    );
                }
            } else {

                ticket = roomB.sellTicket();
                if (ticket != null) {
                    soldCount++;
                    TablePrinter.printRow(
                            counterName + " bán vé phòng B",
                            counterName + " đã bán vé " + ticket.ticketId
                    );
                }
            }

            if (ticket == null) {
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

        synchronized (roomA) {
            try {
                Thread.sleep(50); // giúp dễ xảy ra deadlock
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            synchronized (roomB) {

                if (roomA.remainingTickets() > 0 && roomB.remainingTickets() > 0) {

                    Ticket a = roomA.sellTicket();
                    Ticket b = roomB.sellTicket();

                    soldCount++;

                    TablePrinter.printRow(
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