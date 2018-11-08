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