package thread;

public class YieldThread {

    public static void main(String[] args) {
        SameLevel A = new SameLevel("A");
        SameLevel B = new SameLevel("B");
        A.start();
        B.start();
    }

}


class SameLevel extends Thread {

    public SameLevel(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 9) {
            i++;
            if (i % 2 == 0) {
                System.out.println(getName() + i + " 让出执行时间，等待CPU重新调用");
                Thread.yield();
                System.out.println(getName() + i + " 获得CPU资源，继续执行");
            } else {
                try {
                    Thread.sleep(100l);
                    System.out.println(getName() + i + " 直接执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
