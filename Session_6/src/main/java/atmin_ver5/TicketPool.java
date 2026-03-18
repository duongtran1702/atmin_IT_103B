package atmin_ver5;

import java.util.*;

class TicketPool {

    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String room, int capacity) {
        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(room + "-" + String.format("%03d", i), false));
        }
    }

    public synchronized Ticket holdTicket(boolean vip) {

        for (Ticket t : tickets) {

            if (!t.isHeld) {
                t.isHeld = true;
                t.isVIP = vip;
                t.holdExpiryTime = System.currentTimeMillis() + 5000;

                return t;
            }
        }

        return null;
    }

    public synchronized boolean sellHeldTicket(Ticket ticket) {

        if (ticket != null && ticket.isHeld) {

            if (System.currentTimeMillis() <= ticket.holdExpiryTime) {

                tickets.remove(ticket);
                return true;
            }
        }

        return false;
    }

    public synchronized void releaseExpiredTickets() {
        long now = System.currentTimeMillis();
        for (Ticket t : tickets) {

            if (t.isHeld && now > t.holdExpiryTime) {
                t.isHeld = false;
                Logger.log(
                        "TimeoutManager",
                        "Vé " + t.id + " hết hạn giữ, trả lại kho"
                );
            }
        }
    }
}
