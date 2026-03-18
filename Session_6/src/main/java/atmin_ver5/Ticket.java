package atmin_ver5;

class Ticket {
    String id;
    boolean isVIP;
    boolean isHeld = false;
    long holdExpiryTime = 0;

    Ticket(String id, boolean isVIP) {
        this.id = id;
        this.isVIP = isVIP;
    }
}
