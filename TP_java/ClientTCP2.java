import java.net.*;
import java.io.*;

public class ClientTCP2 {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 2016);

            DataOutputStream dOut =
                new DataOutputStream(socket.getOutputStream());

            dOut.writeUTF(args[0]);

            dOut.flush();

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
