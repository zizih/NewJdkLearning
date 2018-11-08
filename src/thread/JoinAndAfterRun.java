package thread;

public class JoinAndAfterRun {

    public static void main(String[] args) {
        Thread before = new JoinThread("T-before", null);
        Thread after = new JoinThread("T-after", before);
        before.start();
        after.start();
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
        if (joinThread == null) {
            try {
                // before进程慢一点执行，体现join的效果时等待before执行后after才执行
                System.out.println(getName() + " 在休眠");
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (joinThread != null && joinThread.isAlive()) {
            try {
                System.out.println(getName() + " 等 " + joinThread.getName() + " 先执行");
                joinThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " 执行完了");
    }
}
