import java.net.*;
import java.util.*;

public class servertest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();

        System.out.println("Enter the message to be sent :- ");
        String str = sc.nextLine();

        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 21);

        ds.send(dp);
        ds.close();
    }
}
