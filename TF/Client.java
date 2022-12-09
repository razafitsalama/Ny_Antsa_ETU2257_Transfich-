package fich;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // En-tête �* envoyer
        String[] tab = { "Serveur1", "Serveur2", "Serveur3", "Client" };

        // Ouverture de la fonctionication

        Socket sock = new Socket(InetAddress.getLocalHost(), 9001);
        ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());

        // Envoi de l'en-tête
        out.writeInt(tab.length);
        for (int i = 0; i < tab.length; i++)
            out.writeUTF(tab[i]);

        // Envoi du fichier
        Fonction.transfert(
                new FileInputStream(new File("D:\\itu\\S3\\Mr Naina\\TF\\sary\\coq1.JPG")),
                out,
                true);

        // Fermeture de la fonctionication
        sock.close();
    }
}