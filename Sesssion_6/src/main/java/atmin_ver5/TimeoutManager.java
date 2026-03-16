package atmin_ver5;

import java.util.List;

class TimeoutManager extends Thread {

    List<TicketPool> pools;

    TimeoutManager(List<TicketPool> pools) {
        this.pools = pools;
    }

    public void run() {

        while (true) {

            try {

                for (TicketPool pool : pools) {
                    pool.releaseExpiredTickets();
                }

                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}