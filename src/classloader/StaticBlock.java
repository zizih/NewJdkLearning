package classloader;

public class StaticBlock {


    public static int i = 0;

    static {
        i = 1;
        System.out.println("static block: " + i);
    }

    public StaticBlock() {
        i = 2;
        System.out.println("constructor: " + i);
    }

    public static void main(String[] args) {
        new StaticBlock();
        System.out.println("i=" + i);
    }
}
