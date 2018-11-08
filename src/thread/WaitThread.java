package thread;

public class WaitThread {
    public static void main(String[] args) {
        //创建数据对象
        Person p = new Person();
        //创建线程任务
        Input in = new Input(p);
        Output out = new Output(p);
        //创建线程
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        //开始
        t1.start();
        t2.start();
    }
}

class Person {
    private String name;
    private boolean flag = false;//默认数据为空

    //封装写数据方法
    synchronized void setData(String name) {
        if (flag)//里面没有数据，将写数据进程等待
            try {
                System.out.println("写数据等待...");
                this.wait();
            } catch (InterruptedException ex) {
            }//因为wait方法有抛出异常（wait继承于Object）
        this.name = name;
        System.out.println("写入数据： " + name);
        flag = true;//数据已经写入，转换标识
        this.notify();//唤醒取数据进程
    }

    //封装取数据方法
    synchronized void getData() {
        if (!flag)//不为空，则读数据进程等待
            try {
                System.out.println("读数据等待...");
                this.wait();
            } catch (InterruptedException ex) {
            }
        System.out.println("读取数据： " + name);
        flag = false;
        this.notify();
    }
}

//定义写数据线程任务
class Input implements Runnable {
    Person p;

    Input(Person p) {
        this.p = p;
    }

    public void run() {
        int i = 0;
        while (i < 20) {
            p.setData("" + i);
            i++;
        }
    }
}

//定义取数据进程
class Output implements Runnable {
    Person p;

    Output(Person p) {
        this.p = p;
    }

    public void run() {
        while (true) {
            p.getData();
        }
    }
}
