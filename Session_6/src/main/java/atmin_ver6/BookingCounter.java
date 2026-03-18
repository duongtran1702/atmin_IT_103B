package atmin_ver6;

import java.util.List;
import java.util.Random;

class BookingCounter implements Runnable {

    String name;
    List<Room> rooms;
    boolean running = true;

    public BookingCounter(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void run() {

        System.out.println(name + " bắt đầu bán vé...");

        Random rand = new Random();

        while (running) {

            Room r = rooms.get(rand.nextInt(rooms.size()));

            if (r.sellTicket()) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }

    public void stop() {
        running = false;
    }
}
