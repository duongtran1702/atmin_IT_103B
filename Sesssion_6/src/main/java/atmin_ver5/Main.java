package atmin_ver5;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Logger.printHeader();

        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 5);
        TicketPool roomC = new TicketPool("C", 5);

        List<TicketPool> pools = Arrays.asList(roomA, roomB, roomC);

        TimeoutManager manager = new TimeoutManager(pools);
        manager.start();

        BookingCounter c1 = new BookingCounter("Quầy 1", roomA, true);
        BookingCounter c2 = new BookingCounter("Quầy 2", roomA, false);
        BookingCounter c3 = new BookingCounter("Quầy 3", roomB, false);
        BookingCounter c4 = new BookingCounter("Quầy 4", roomC, true);
        BookingCounter c5 = new BookingCounter("Quầy 5", roomA, false);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

        try {

            c1.join();
            c2.join();
            c3.join();
            c4.join();
            c5.join();

            System.out.println("\n=== TẤT CẢ QUẦY ĐÃ XỬ LÝ XONG ===");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}