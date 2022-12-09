package fich;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author othmane
 */
public class Fonction {

    public static void transfert(InputStream in, OutputStream out, boolean closeOnExit) throws IOException {
        byte buf[] = new byte[1024];

        int n;
        while ((n = in.read(buf)) != -1)
            out.write(buf, 0, n);
            System.out.println("mety");

        if (closeOnExit) {
            in.close();
            out.close();
        }
    }
}