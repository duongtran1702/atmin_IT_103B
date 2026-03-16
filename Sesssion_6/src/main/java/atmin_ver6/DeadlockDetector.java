package atmin_ver6;

import java.lang.management.*;

class DeadlockDetector implements Runnable {

    public void run() {

        System.out.println("Đang quét deadlock...");

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long[] ids = bean.findDeadlockedThreads();

        if (ids == null) {
            System.out.println("Không phát hiện deadlock.");
        } else {
            System.out.println("Phát hiện deadlock!");
        }
    }
}
