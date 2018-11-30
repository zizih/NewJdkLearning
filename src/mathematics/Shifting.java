package mathematics;

public class Shifting {


    public static void main(String[] args) {
        int i = 4;
        System.out.println(i >> 2); // 除以4
        System.out.println(i >> 3); // 除以8

        System.out.println(i | 3);  // i |= 3;  // 按位或  0000 0100 |= 0000 0011  得到0000 0111,答案是 i＝7

        System.out.println(i ^ 3); // i ^= 3;  // 按位异或  0000 0100 |= 0000 0011  得到0000 0111,答案是 i＝7

        System.out.println(~i); // 按位非,单目运算符  加1取反
    }

}
