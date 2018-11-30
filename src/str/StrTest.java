package str;

/**
 * Author: hezi.hz
 * Date: 11/29/18
 */
public class StrTest {

    public static void main(String[] args) {
        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";

        System.out.println(a == b);                     // false
        System.out.println(b == c);                     // false
        System.out.println(a == c);                     // true
        System.out.println(a.equals(b));                // true
        System.out.println(a.equals(c));                // true
        System.out.println(a.intern() == b.intern());   // true
    }

}
