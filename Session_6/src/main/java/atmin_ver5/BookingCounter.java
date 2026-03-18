package atmin_ver5;

class BookingCounter extends Thread {

    String name;
    TicketPool pool;
    boolean vip;

    public BookingCounter(String name, TicketPool pool, boolean vip) {
        this.name = name;
        this.pool = pool;
        this.vip = vip;
    }

    public void run() {

        try {

            Ticket ticket = pool.holdTicket(vip);

            if (ticket == null) {
                Logger.log(
                        name + " đặt vé",
                        "Không còn vé");
                return;
            }

            Logger.log(
                    name + " giữ vé " + ticket.id,
                    "Vui lòng thanh toán trong 5s");

            Thread.sleep(3000);

            boolean success = pool.sellHeldTicket(ticket);

            if (success) {
                Logger.log(
                        name + " thanh toán",
                        "Thanh toán thành công " + ticket.id);
            } else {
                Logger.log(
                        name + " thanh toán",
                        "Thanh toán thất bại " + ticket.id);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
