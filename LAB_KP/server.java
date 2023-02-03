import java.net.*;
import java.io.*;

// 3. Using TCP/IP sockets, write a client – server program to make the client send
//the file name and to make the server send back the contents of the requested file if present.

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock = new ServerSocket(4000);

        System.out.println("\n\nServer ready for connection. Waiting for client request");
        Socket sock = sersock.accept();

        System.out.println("Connection is successful & waiting for chatting on the client side ");
        InputStream istream = sock.getInputStream();

        BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
        String fname = fileRead.readLine();

        BufferedReader contentRead = new BufferedReader(new FileReader(fname));
        OutputStream ostream = sock.getOutputStream();

        PrintWriter pwrite = new PrintWriter(ostream, true);
        String str;

        while ((str = contentRead.readLine()) != null) 
            pwrite.println(str);

        System.out.println("Contents of the file are sent...");

        sock.close();
        sersock.close();
        pwrite.close();
    }
}