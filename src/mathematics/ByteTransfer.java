package mathematics;

import java.nio.ByteBuffer;

public class ByteTransfer {


    private static ByteBuffer buffer = ByteBuffer.allocate(8);

    public static void main(String[] args) {

        byte b = (byte) 4;   //字节(byte) = 8位二进制(bit)
        System.out.println(b);
        System.out.println((byte) 4);   // int转换为byte

        int i = 4 & 0xFF;   // int是4个字节  32位
        System.out.println(i);
        System.out.println(0xFF);
        System.out.println(4 & 0xFF);   // byte转换为int， 与1111 1111进行与运算

        byte c = 127;
        byte d = 127;
        System.out.println("c=" + Integer.toBinaryString(c));
        System.out.println("d=" + Integer.toBinaryString(d));


        /**
         *                                         1111 1111 +                               1111 1111
         * 提升到int  0000 0000 0000 0000 0000 0000 1111 1111 + 0000 0000 0000 0000 0000 0000 1111 1111
         *         = 0000 0000 0000 0000 0000 0001 1111 1110 //这个不对哦？
         *         = 1111 1111 1111 1111 1111 1111 1111 1110 //怎么变成这个的？ 应该先计算，不会先提升int, 仍然是8位，是溢出，然后高位补1
         */
        System.out.printf("127 + 127=");
        System.out.println(127 + 127);
        System.out.println(Integer.toBinaryString(127 + 127));
        System.out.println("c+d = " + (c + d));
        // d = c + d; 首先会将它们提升到 int 类型，然后在执行加法操作 出现变异错误 cannot convert from int to byte
        d += c; // ok
        System.out.println("d += c " + Integer.toBinaryString(d));
        System.out.println(d);

    }


    //byte 数组与 int 的相互转换（int是4个字节，32位二进制）
    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    //int 数组与 byte 的相互转换（int是4个字节，32位二进制）
    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i << 24) & 0xFF),
                (byte) ((i << 16) & 0xFF),
                (byte) ((i << 8) & 0xFF),
                (byte) (i & 0xFF)};
    }

    //byte 数组与 long 的相互转换
    public static byte[] longToBytes(long x) {
        buffer.putLong(0, x);
        return buffer.array();
    }

    public static long bytesToLong(byte[] bytes) {
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();//need flip
        return buffer.getLong();
    }

}
