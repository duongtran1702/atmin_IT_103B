package atmin_ver6;

class Room {

    String name;
    int totalTickets;
    int soldTickets = 0;

    public Room(String name, int totalTickets) {
        this.name = name;
        this.totalTickets = totalTickets;
    }

    public synchronized boolean sellTicket() {

        if (soldTickets < totalTickets) {
            soldTickets++;
            return true;
        }

        return false;
    }

}
