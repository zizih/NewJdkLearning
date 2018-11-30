package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Author: hezi.hz
 * Date: 11/17/18
 */
public class Semaphore5 {

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(1); // 1:ª•≥‚–≈∫≈¡ø
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int finalI = i;

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        int availablePermits = semaphore.availablePermits();
                        System.out.println("index=" + finalI + ", availablePermits="
                                           + availablePermits);
                        if (availablePermits == 0) {
                            System.out.println("-------------------------");
                        }
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            };
            executorService.execute(r);
        }
    }
}
