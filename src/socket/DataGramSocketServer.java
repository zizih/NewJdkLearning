package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DataGramSocketServer {

    public static void main(String[] args) {
        try {

            //接受客户端的数据
            DatagramSocket server = new DatagramSocket(8080);
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            server.receive(packet);
            System.out.println(new String(data, "UTF8"));

            //向客户端发送数据
            data = "server data".getBytes();
            DatagramPacket packet2 = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
            server.send(packet2);
            server.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

