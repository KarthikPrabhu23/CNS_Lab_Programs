import java.util.Scanner;

public class leak {

    public static void main(String[] args) {
        int size, nop, i, j;
        int[] inp = new int[100];
        int out;
        int[] out_r = new int[100];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the bucket:");
        size = sc.nextInt();
        System.out.println("Enter the number of packets:");
        nop = sc.nextInt();
        System.out.println("Enter the input rate:");
        for (i = 0; i < nop; i++) {
            inp[i] = sc.nextInt();
        }
        System.out.println("Enter the output rate:");
        out = sc.nextInt();
        j = 0;
        for (i = 0; i < nop; i++) {
            System.out.println();

            if (inp[i] <= 0) {
                System.out.println("Underflow");
            }
            else if (inp[i] <= size) {
                while (inp[i] >= out) {
                    out_r[j++] = out;
                    inp[i] = inp[i] - out;
                    System.out.println("Packet transmission: " + out_r[j - 1] + "\n");
                }
                if (inp[i] > 0) {
                    out_r[j++] = inp[i];
                    System.out.println("Packet transmission: " + out_r[j - 1] + "\n");
                }
            }
            else {
                System.out.println("Overflow");

            }
        }
    }
}
