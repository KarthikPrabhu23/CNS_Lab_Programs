// 5. PROGRAM FOR A SIMPLE RSA PROGRAM TO ENCRYPT & DECRYPT DATA

import java.util.*;
import java.io.*;

class RSA1 {
    static int multi(int p, int q, int n)
    {
        int k = 1;
        for (int i = 1; i <= q; i++)
            k = (k * p) % n;
        return (int) k;
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        int[] pt = new int[100];
        int[] ct = new int[100];

        int p, q, n, e, d, i, z;
        String msg1;

        System.out.println("\nEnter two large prime numbers P & Q :-");
        p = sc.nextInt();
        q = sc.nextInt();

        System.out.println("\nEnter 'e' value");
        e = sc.nextInt();

        System.out.println("\nEnter message :-");
        msg1 = br.readLine();
        char msg[] = msg1.toCharArray();

        n = p * q;
        z = (p - 1) * (q - 1);

        for (d = 1; d < z; ++d)
            if ((e * d) % z == 1)
                break;

        // copy msg in pt
        for (i = 0; i < msg.length; i++)
            pt[i] = msg[i];

        System.out.println("\nPlain text is :-\np=" + p + " \nq=" + q + " \ne=" + e + " \nz=" + z + " \nd=" + d);

        System.out.println("\nCipher text :-");
        for (i = 0; i < msg.length; i++)
            ct[i] = multi(pt[i], e, n);    // multi(p,q,n)

        // Print cipher text :-
        for (i = 0; i < msg.length; i++)
            System.out.print("\t " + ct[i]);

        System.out.println("\n Plain text :-");
        for (i = 0; i <= msg.length; i++)
            pt[i] = multi(ct[i], d, n);     // multi(p,q,n)

        // Print plain text
        for (i = 0; i <= msg.length; i++)
            System.out.print("\t " + pt[i]);

        for (i = 0; i <= msg.length; i++)
            System.out.print("\t " + (char) pt[i]);
    }
}




