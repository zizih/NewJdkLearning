package mathematics;

public class ModInt {

    public static void main(String[] args) {
        int h = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 4 == 0) { // 求余
                h++;
                System.out.println(i);
            }
        }
        System.out.println(h);
    }

}
