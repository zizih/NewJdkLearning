package classloader;

public class StaticBlockAndVariable {


    static {
        i = 0;
        //  System.out.println(i); illegal forward refence
    }

    private static int i;

}
