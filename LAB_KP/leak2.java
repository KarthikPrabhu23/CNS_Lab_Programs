import java.util.*;

public class leak2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the bucket size");
        int BS = sc.nextInt();

        System.out.println("Enter number of packets :-");
        int nop = sc.nextInt();
        int[] in = new int[nop];

        System.out.println("Enter " + nop + " data input bits :- ");
        for (int i = 0; i < nop; i++) {
            in[i] = sc.nextInt();
        }

        System.out.println("Enter output rate");
        int out = sc.nextInt();

        System.out.println("\nOutput is ");
        for (int i = 0; i < nop; i++) {
            if (in[i] > BS)
                System.out.println("Overflow for " + in[i]);
            else if (in[i] < 0)
                System.out.println("Underflow for " + in[i]);
            else {
                while (in[i] > out) {
                    in[i] -= out;
                    System.out.println(out);
                }
                System.out.println(in[i]);
            }
        }
    }
}
