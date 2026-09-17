import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) throws Exception {

        DatagramSocket sock = new DatagramSocket(1234);

        while (true) {

            System.out.println("- Waiting data");


            byte[] buffer = new byte[1024];
            DatagramPacket packet =
                new DatagramPacket(buffer, buffer.length);


            sock.receive(packet);


            String str = new String(
                packet.getData(),
                0,
                packet.getLength()
            );

            System.out.println("str=" + str);


            byte[] responseData = str.getBytes();



            DatagramPacket response =
                new DatagramPacket(
                    responseData,
                    responseData.length,
                    packet.getAddress(),
                    packet.getPort()
                );


            sock.send(response);
        }
    }
}


