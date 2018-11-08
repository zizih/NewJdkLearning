package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class DataGramSocketClient {

    public static void main(String[] args) {
        try {
            // 向服务器发送数据
            InetAddress address = InetAddress.getByName("localhost");
            String data = "client data";
            DatagramPacket packet = new DatagramPacket(data.getBytes("UTF8"), data.length(), address, 8080);
            DatagramSocket client = new DatagramSocket();
            client.send(packet);

            // 接收服务器响应
            byte[] data2 = new byte[1024];
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
            client.receive(packet2);
            System.out.println(new String(data2, "UTF8"));
            client.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

