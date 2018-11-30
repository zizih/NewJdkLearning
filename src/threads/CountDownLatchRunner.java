package threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Author: hezi.hz
 * Date: 11/24/18
 */
public class CountDownLatchRunner {

    public static void main(String[] args) {
        int runnerNum = 5;
        CountDownLatch readyLatch = new CountDownLatch(runnerNum);
        CountDownLatch startLatch = new CountDownLatch(1);
        for (int i = 0; i < runnerNum; i++) {
            Thread th = new Thread(new Runner("t-" + i, readyLatch, startLatch));
            th.start();

        }
        try {
            readyLatch.await(); // 阻塞，直到readyLatch倒计数为0 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startLatch.countDown(); // 倒计数startLatch为0
        System.out.println("所有运动员准备完毕。。。");
    }
}

class Runner implements Runnable {

    CountDownLatch readyLatch;
    CountDownLatch startLatch;
    Random         RANDOM = new Random();

    Runner(String name, CountDownLatch readyLatch, CountDownLatch startLatch) {
        Thread.currentThread().setName(name);
        this.readyLatch = readyLatch;
        this.startLatch = startLatch;
    }

    @Override
    public void run() {
        int readyTime = RANDOM.nextInt(1000);
        System.out.println(Thread.currentThread().getName() + "需要" + readyTime + "毫秒准备");
        try {
            Thread.sleep(readyTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readyLatch.countDown();
        System.out.println(Thread.currentThread().getName() + "准备完毕");
        try {
            startLatch.await();                // 阻塞，直到startLatch倒计数为0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "开跑");// startLatch倒计数为0, 继续执行
    }
}
