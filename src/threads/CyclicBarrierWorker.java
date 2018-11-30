package threads;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author: hezi.hz
 * Date: 11/24/18
 */
public class CyclicBarrierWorker {

    public static void main(String[] args) {
        int workerNum = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(workerNum, () -> {
            System.out.println("所有小伙伴都已经完成");
        });
        for (int i = 0; i < workerNum; i++) {
            Thread th = new Thread(new Worker("th-" + i, cyclicBarrier));
            th.start();
        }
        //        new Thread(() -> System.out.println("In Java8, Lambda expression")).start();
    }
}

class Worker implements Runnable {

    CyclicBarrier cyclicBarrier;
    Random        RANDOM = new Random();

    Worker(String name, CyclicBarrier cyclicBarrier) {
        Thread.currentThread().setName(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        int readyTime = RANDOM.nextInt(1000);
        System.out.println(Thread.currentThread().getName() + "需要" + readyTime + "写入数据，等待小伙伴");
        try {
            Thread.sleep(readyTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            cyclicBarrier.await(); // 阻塞，直到所有线程都调用了await
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "继续干活。。");// startLatch倒计数为0, 继续执行
    }
}
