package transaction;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestThread extends Thread {
    private ReentrantReadWriteLock lock;
    private String threadName;
    private boolean isWriter;

    public TestThread(ReentrantReadWriteLock lock, String name, boolean isWriter) {
        this.lock = lock;
        this.threadName = name;
        this.isWriter = isWriter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(0l);
            wait();
            wait(0); // ÎÞÐÝÖ¹µÈ´ý
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (isWriter) {
                    lock.writeLock().lock();
                    Thread.sleep(1000l);
                    System.out.println(this.threadName + " is writer");
                } else {
                    lock.readLock().lock();
                    System.out.println(System.currentTimeMillis() + ":" + threadName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (isWriter) {
                    lock.writeLock().unlock();
                } else {
                    lock.readLock().unlock();
                }
            }
            break;
        }
    }

}