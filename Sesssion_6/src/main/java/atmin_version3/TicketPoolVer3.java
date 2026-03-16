package atmin_version3;

import atmin.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketPoolVer3 {
    String roomName;
    List<TicketVer3> tickets = new ArrayList<>();
    int idAuto = 1;


    public TicketPoolVer3(String roomName, int totalTickets) {
        this.roomName = roomName;

        for (int i = 1; i <= totalTickets; i++) {
            String id = String.format("%s-%03d", roomName, idAuto++);
            tickets.add(new TicketVer3(id, roomName));
        }
    }

    public synchronized TicketVer3 sellTicket() {
        for (TicketVer3 ticket : tickets) {
            if (!ticket.isSold) {
                ticket.isSold = true;
                return ticket;
            }
        }
        return null;
    }

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            String id = String.format("%s-%03d", roomName, idAuto++);
            tickets.add(new TicketVer3(id, roomName));
        }
    }

    public int remainingTickets() {
        int count = 0;
        for (TicketVer3 t : tickets) {
            if (!t.isSold) count++;
        }
        return count;
    }


}
