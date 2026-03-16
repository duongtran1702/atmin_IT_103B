package atmin;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    String roomName;
    List<Ticket> tickets = new ArrayList<>();
    int idAuto = 1;


    public TicketPool(String roomName, int totalTickets) {
        this.roomName = roomName;

        for (int i = 1; i <= totalTickets; i++) {
            String id = String.format("%s-%03d", roomName, idAuto++);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket sellTicket() {
        for (Ticket ticket : tickets) {
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
            tickets.add(new Ticket(id, roomName));
        }
    }

    public int remainingTickets() {
        int count = 0;
        for (Ticket t : tickets) {
            if (!t.isSold) count++;
        }
        return count;
    }


}
