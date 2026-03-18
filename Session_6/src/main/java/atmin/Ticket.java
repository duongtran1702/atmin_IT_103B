package atmin;

public class Ticket {
    public String ticketId;
    String roomName;
    public boolean isSold;

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false;
    }
}
