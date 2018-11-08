package concurrent;

public class Singleton {

    private static Singleton uniqInstance;

    public Singleton() {
    }

    public static Singleton getUniqInstance() {
        if (uniqInstance == null) {
            synchronized (Singleton.class) {
                if (uniqInstance == null) {
                    uniqInstance = new Singleton();
                }
            }
        }
        return uniqInstance;
    }
}
