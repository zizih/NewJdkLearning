package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Author: hezi.hz
 * Date: 11/24/18
 */
public class ForkJoinPoolDisunderstand {

    public static void main(String[] args) {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(50);
        Task task = new Task(products, 0, products.size(), 0.2);
        System.out.println("task start");
        //创建pool使用默认的无参构造函数，线程池使用的线程数由Runtime.getRuntime().availableProcessors()返回值决定
        ForkJoinPool pool = new ForkJoinPool();
        //在池中使用execute()方法执行这个任务。一个异步调用，而主线程继续它的执行。
        pool.execute(task);
        //显示每隔5毫秒池中的变化信息
        do {
            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.println("------------------------");
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();
        //使用isCompletedNormally()方法检查假设任务完成时没有出错，在这种情况下，写入一条信息到控制台。
        if (task.isCompletedNormally()) {
            System.out.printf("Main: The process has completed normally.\n");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
            }
        }
        System.out.println("Main: End of the program.\n");
    }

}

class Task extends RecursiveAction {
    private static final long serialVersionUID = 1L;

    private List<Product>     products;

    private int               first;
    private int               last;

    private double            increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < 10) {
            updatePrices();
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks: %s\n", getQueuedTaskCount());
            Task t1 = new Task(products, first, middle + 1, increment);
            Task t2 = new Task(products, middle + 1, last, increment);
            //它调用invokeAll()方法，执行每个任务所创建的子任务。这是一个同步调用，这个任务在继续（可能完成）它的执行之前，必须等待子任务的结束。
            // 当任务正在等待它的子任务（结束）时，正在执行它的工作线程执行其他正在等待的任务。
            // 在这种行为下，Fork/Join框架比Runnable和Callable对象本身提供一种更高效的任务管理。
            invokeAll(t1, t2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() * (1 + increment));
        }
    }
}

class Product {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product" + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
