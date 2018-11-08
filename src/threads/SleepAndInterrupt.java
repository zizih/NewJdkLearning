package threads;

public class SleepAndInterrupt {


    public static void main(String[] args) throws InterruptedException {
        SleepThread t = new SleepThread("interruptTh");
        t.start();
        Thread.sleep(500l);
        System.out.println(t.getName() + " interrupt ");
        t.interrupt();
    }


}

class SleepThread extends Thread {

    public SleepThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " sleeping ");
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted and running ");
        }
    }
}
