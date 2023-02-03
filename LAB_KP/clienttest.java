import java.util.*;
import java.net.*;

public class clienttest {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds= new DatagramSocket(21);
        Scanner sc= new Scanner(System.in);

        byte [] buf= new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf,1024);
        ds.receive(dp);

        String str= new String(dp.getData(),0,dp.getLength());
        System.out.println("The message from server is ");
        System.out.println(str);
    }
}
