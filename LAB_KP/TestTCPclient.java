import java.io.*;
import java.net.*;

public class TestTCPclient {
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket("127.0.0.1", 4000);

        System.out.println("Enter the FileName :-");
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        String fname = keyRead.readLine();

        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);

        InputStream istream = sock.getInputStream();
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
        String str;

        System.out.println("Contents of the file are :- ");
        while ((str = socketRead.readLine()) != null)
            System.out.println(str);

        pwrite.close();
        sock.close();
        socketRead.close();
    }
}
