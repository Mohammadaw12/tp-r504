import java.net.*;
import java.io.*;

public class ServeurTCP3 {

    public static void main(String[] args) {

        try {
            ServerSocket socketserver = new ServerSocket(2016);

            while (true) {

                System.out.println("Serveur en attente");

                Socket socket = socketserver.accept();

                System.out.println("Connexion d'un client");

                DataInputStream dIn =
                    new DataInputStream(socket.getInputStream());

                DataOutputStream dOut =
                    new DataOutputStream(socket.getOutputStream());

                // Réception du message
                String msg = dIn.readUTF();

                System.out.println("Message reçu : " + msg);

                // Inversion de la chaîne
                String rev = new StringBuilder(msg).reverse().toString();

                // Envoi de la chaîne inversée
                dOut.writeUTF(rev);
                dOut.flush();

                System.out.println("Message envoyé : " + rev);

                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
