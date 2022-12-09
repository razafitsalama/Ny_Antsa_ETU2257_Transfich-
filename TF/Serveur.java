package fich;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException {
        // Ouverture d'une fonctionication
        Socket sock = new ServerSocket(9001).accept();
        ObjectInputStream in = new ObjectInputStream(sock.getInputStream());

        // Réception de l'en-tête
        int n = in.readInt();

        String[] tab = new String[n];

        for (int i = 0; i < n; i++)
            tab[i] = in.readUTF();

        // Réception du fichier
        Fonction.transfert(in, new FileOutputStream(new File("D:\\itu\\S3\\Mr Naina\\TF")), true);

        // Fermeture de la fonctionication
        sock.close();

        // Affichage de l'en-tête
        for (String s : tab)
            System.out.println(s);

    }
}