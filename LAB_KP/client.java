import java.net.*;
import java.io.*;

//  3. Using TCP/IP sockets, write a client – server program to make the client send
//the file name and to make the server send back the contents of the requested file if present.

public class client {
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket("127.0.0.1", 4000);

        System.out.print("\n\nEnter the file name ");
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        String fname = keyRead.readLine();

        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);

        System.out.println("Contents of the file :- ");
        InputStream istream = sock.getInputStream();
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));

        String str;

        while ((str = socketRead.readLine()) != null) {
            System.out.println(str);
        }

        pwrite.close();
        socketRead.close();
        keyRead.close();
    }
}
		


