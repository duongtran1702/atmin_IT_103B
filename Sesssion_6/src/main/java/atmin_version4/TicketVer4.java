package atmin_version4;

public class TicketVer4 {
    public String ticketId;
    String roomName;
    public boolean isSold;

    public TicketVer4(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false;
    }
}
