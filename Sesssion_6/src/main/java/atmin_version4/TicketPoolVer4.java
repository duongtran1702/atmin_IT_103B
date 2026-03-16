package atmin_version4;

import java.util.ArrayList;
import java.util.List;

public class TicketPoolVer4 {
    String roomName;
    List<TicketVer4> ticketVer4s = new ArrayList<>();
    int idAuto = 1;

    public TicketPoolVer4(String roomName, int totalTickets) {
        this.roomName = roomName;

        for (int i = 1; i <= totalTickets; i++) {
            String id = String.format("%s-%03d", roomName, idAuto++);
            ticketVer4s.add(new TicketVer4(id, roomName));
        }
    }

    public synchronized TicketVer4 sellTicket() {

        while (remainingTickets() == 0) {

            if (TicketSupplierVer4.roundTemp <= 0) {
                return null; // không còn vé và không còn supply
            }

            TablePrinterVer4.printRow(
                    "Hệ thống",
                    "Hết vé phòng " + roomName + ", thread đang chờ..."
            );

            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            TablePrinterVer4.printRow(
                    "Hệ thống",
                    "Phòng " + roomName + " có vé mới, thread thức dậy"
            );
        }

        for (TicketVer4 ticketVer4 : ticketVer4s) {
            if (!ticketVer4.isSold) {
                ticketVer4.isSold = true;
                return ticketVer4;
            }
        }

        return null;
    }

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            String id = String.format("%s-%03d", roomName, idAuto++);
            ticketVer4s.add(new TicketVer4(id, roomName));
        }
        notifyAll();
    }

    public synchronized int remainingTickets() {
        int count = 0;
        for (TicketVer4 t : ticketVer4s) {
            if (!t.isSold) count++;
        }
        return count;
    }

}
