package atmin_ver6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class CinemaSystem {

    List<Room> rooms = new ArrayList<>();
    List<BookingCounter> counters = new ArrayList<>();

    ExecutorService pool;

    public void start(int roomCount, int ticketsPerRoom, int counterCount) {

        for (int i = 0; i < roomCount; i++) {

            Room r = new Room(
                    String.valueOf((char)('A' + i)),
                    ticketsPerRoom
            );

            rooms.add(r);
        }

        pool = Executors.newFixedThreadPool(counterCount);

        for (int i = 1; i <= counterCount; i++) {

            BookingCounter c = new BookingCounter(
                    "Quầy " + i,
                    rooms
            );

            counters.add(c);

            pool.submit(c);
        }

        System.out.println("Đã khởi tạo hệ thống với "
                + roomCount + " phòng, "
                + (roomCount * ticketsPerRoom) + " vé, "
                + counterCount + " quầy");
    }

    public void pause() {
        counters.forEach(BookingCounter::stop);
        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void stats() {

        System.out.println("=== THỐNG KÊ HIỆN TẠI ===");

        int revenue = 0;

        for (Room r : rooms) {

            System.out.println(
                    "Phòng " + r.name + ": Đã bán "
                            + r.soldTickets + "/" + r.totalTickets
            );

            revenue += r.soldTickets * 75000;
        }

        System.out.println("Tổng doanh thu: " + revenue + " VNĐ");
    }
}
