package threads;

public class ThreadAndRunable {

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();


        Runnable myRunable = new MyRunable();
        new Thread(myRunable).start();
        new Thread(myRunable).start();
        new Thread(myRunable).start();
    }

}


class MyThread extends Thread {

    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.ticket > 0) {
                System.out.println("Thread卖票：ticket" + this.ticket--);
            }
        }
    }
}


class MyRunable implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.ticket > 0) {
                System.out.println("Runable卖票：ticket" + this.ticket--);
            }
        }
    }
}