package transaction;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void blockByWriteLock() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();

        TestThread[] threads = new TestThread[4];
        for (int i = 0; i <4; i++) {
            boolean isWriter = (i + 1) % 4 == 0 ? true : false;
            TestThread thread = new TestThread(lock, "thread-" + (i + 1), isWriter);
            threads[i] = thread;
            threads[i].start();
            System.out.println(System.currentTimeMillis() + ":" + threads[i].getName() + ": start" + (isWriter ? " is Writer" : ""));
        }
    }

    public static void main(String[] args) {
        blockByWriteLock();
    }
}