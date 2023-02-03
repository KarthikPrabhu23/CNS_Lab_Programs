import java.net.*;
import java.util.*;
import java.io.*;

public class TestTCPserver {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock = new ServerSocket(4000);
        Socket sock = sersock.accept();
        System.out.println("Connection established ");

        InputStream istream = sock.getInputStream();
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
        String fname = fileRead.readLine();

        BufferedReader contentRead = new BufferedReader(new FileReader(fname));
        String str;

        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        while ((str = contentRead.readLine()) != null)
            pwrite.println(str);

        pwrite.close();
        sersock.close();
        sock.close();
    }
}
