package atmin_version3;

import atmin.BookingCounter;
import atmin.TablePrinter;
import atmin.TicketPool;
import atmin_version2.TicketSupplier;

public class MainVer3 {

    public static void main(String[] args) throws Exception {

        TicketPoolVer3 roomA = new TicketPoolVer3("A", 10);
        TicketPoolVer3 roomB = new TicketPoolVer3("B", 10);
        TablePrinter.printHeader();

        BookingCounterVer3 counter1 = new BookingCounterVer3("Quầy 1", roomA, roomB);
        BookingCounterVer3 counter2 = new BookingCounterVer3("Quầy 2", roomB, roomA);
        TicketSupplierVer3 supplier =
                new TicketSupplierVer3(roomA, roomB, 3, 3000, 2);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);


        t1.start();
        t2.start();
        t3.start();


        t1.join();
        t2.join();
        t3.join();


        TablePrinter.printFooter();

        System.out.println("\nKết thúc chương trình");

        System.out.println("Quầy 1 bán được: " + counter1.soldCount + " vé");
        System.out.println("Quầy 2 bán được: " + counter2.soldCount + " vé");

        System.out.println("Vé còn lại phòng A: " + roomA.remainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.remainingTickets());
    }
}