package blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: hezi.hz
 * Date: 11/18/18
 */
public class ArrayBlockingQueueApp {
    public static void main(String[] args) {
        ArrayBlockingQueue<Apple> abq = new ArrayBlockingQueue<Apple>(2);
        Producer producer = new Producer(abq);
        Consumer consumer = new Consumer(abq);

        for (int i = 0; i < 10; i++) {
            new Thread(producer).start();
            new Thread(consumer).start();
        }

    }
}

class Apple {
    long id;

    Apple(long id) {
        this.id = id;
    }
}

class Producer implements Runnable {

    private ArrayBlockingQueue<Apple> abq;
    private AtomicLong                id = new AtomicLong();

    Producer(ArrayBlockingQueue<Apple> abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true) {
            produce();
        }
    }

    void produce() {
        try {
            Thread.sleep(1000l);
            long nowid = id.getAndIncrement();
            abq.put(new Apple(nowid));
            System.out.println("产生一个苹果:" + nowid);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private ArrayBlockingQueue<Apple> abq;

    Consumer(ArrayBlockingQueue<Apple> abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    void consume() {
        try {
            Apple apple = abq.take();
            System.out.println("消费一个苹果: " + apple.id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}