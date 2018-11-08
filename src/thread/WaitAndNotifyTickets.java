package thread;

public class WaitAndNotifyTickets {


    public static void main(String[] args) throws InterruptedException {
        Theatre t = new Theatre();
        Buyer a = new Buyer("A", t);
        Buyer b = new Buyer("B", t);
        a.start();
        b.start();
    }
}


class Theatre {

    int tickets = 0;

    public void incr() {
        tickets++;
    }

    public synchronized void check(int times) {
        System.out.println("当前票数： " + tickets);
        if (tickets == 0) {
            incr();
            try {
                System.out.println(Thread.currentThread().getName() + " 第 " + times + "次 等待");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        decr(times);
        notifyAll();
    }

    public void decr(int times) {
        if (tickets <= 0) {
            System.out.println("当前无票，" + Thread.currentThread().getName() + " 未取到票");
        } else {
            tickets--;
            System.out.println(Thread.currentThread().getName() + " 第 " + times + "次 取到一张票，还剩" + tickets + "票");
        }
    }

}

class Buyer extends Thread {

    Theatre t;

    public Buyer(String name, Theatre t) {
        this.t = t;
        setName(name);
    }

    @Override
    public void run() {
        t.check(1);
        t.check(2);
    }
}
