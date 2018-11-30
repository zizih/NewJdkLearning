package jvm;

public class JMM {


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
    }

    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
