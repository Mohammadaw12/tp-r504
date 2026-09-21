import java.net.*;
import java.io.*;

public class clienthttp {

    public static void main(String[] args) {

        try {
            // Création du socket vers le serveur HTTP
            Socket socket = new Socket(args[0], 80);

            OutputStreamWriter osw =
                new OutputStreamWriter(socket.getOutputStream());

            InputStreamReader isw =
                new InputStreamReader(socket.getInputStream());

            BufferedWriter bufOut =
                new BufferedWriter(osw);

            BufferedReader bufIn =
                new BufferedReader(isw);

            // Requête HTTP
            String request = "GET / HTTP/1.0\r\n\r\n";

            bufOut.write(request, 0, request.length());
            bufOut.flush();

            // Lecture de la réponse ligne par ligne
            String line = bufIn.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufIn.readLine();
            }

            // Fermeture des flux et du socket
            bufIn.close();
            bufOut.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
