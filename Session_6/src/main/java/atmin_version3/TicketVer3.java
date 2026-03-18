package atmin_version3;

public class TicketVer3 {
    String ticketId;
    String roomName;
    boolean isSold;

    public TicketVer3(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false;
    }
}
