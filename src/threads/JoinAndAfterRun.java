package threads;

public class JoinAndAfterRun {

    public static void main(String[] args) {
        Thread before = new JoinThread("T-before", null);
        Thread after = new JoinThread("T-after", before);
        after.start();
        before.start();
    }
}

class JoinThread extends Thread {

    Thread joinThread;

    public JoinThread(String name, Thread after) {
        super(name);
        this.joinThread = after;
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running...");
        try {
            // before线程慢一点执行，体现join的效果时等待before执行后after才执行
            Thread.sleep(500l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (joinThread != null && joinThread.isAlive()) {
            try {
                System.out.println(joinThread.getName() + " join to " + getName());
                joinThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " finish");
    }

}
