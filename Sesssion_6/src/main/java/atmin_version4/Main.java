package atmin_version4;

public class Main {

    public static void main(String[] args) throws Exception {

        TicketPoolVer4 roomA = new TicketPoolVer4("A", 10);
        TicketPoolVer4 roomB = new TicketPoolVer4("B", 10);
        TablePrinterVer4.printHeader();

        BookingCounterVer4 counter1 = new BookingCounterVer4("Quầy 1", roomA, roomB);
        BookingCounterVer4 counter2 = new BookingCounterVer4("Quầy 2", roomA, roomB);
        TicketSupplierVer4 supplier =
                new TicketSupplierVer4(roomA, roomB, 3, 3000, 2);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        TablePrinterVer4.printFooter();

        System.out.println("\nKết thúc chương trình");

        System.out.println("Quầy 1 bán được: " + counter1.soldCount + " vé");
        System.out.println("Quầy 2 bán được: " + counter2.soldCount + " vé");

        System.out.println("Vé còn lại phòng A: " + roomA.remainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.remainingTickets());
    }
}