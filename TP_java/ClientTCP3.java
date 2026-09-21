import java.net.*;
import java.io.*;

public class ClientTCP3 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Erreur : veuillez donner un message.");
            System.out.println("Exemple : java ClientTCP3 coucou");
            return;
        }

        try {
            Socket socket = new Socket("localhost", 2016);

            DataOutputStream dOut =
                new DataOutputStream(socket.getOutputStream());

            DataInputStream dIn =
                new DataInputStream(socket.getInputStream());

            // Envoi du message au serveur
            dOut.writeUTF(args[0]);
            dOut.flush();

            // Réception de la réponse du serveur
            String rev = dIn.readUTF();

            // Affichage de la chaîne inversée
            System.out.println("Réponse du serveur : " + rev);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
