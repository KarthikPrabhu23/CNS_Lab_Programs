import java.util.*;
// 6. Write a program for congestion control using leaky bucket algorithm.

class LB {
    public static void main(String[] args) {
        int BS, nop, opr, n, i;
        int count = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Bucket size :- ");
        BS = sc.nextInt();

        System.out.println("\nEnter number of packets :- ");
        n = sc.nextInt();

        int DI[] = new int[n];
        System.out.println("\nEnter output rate :- ");
        int rate = sc.nextInt();

        System.out.println("\nEnter " + n + " packet elements :-");
        for (i = 0; i < n; i++)
            DI[i] = sc.nextInt();

        System.out.println("\n\nOutput obtained is :- \n");
        for (i = 0; i < n; i++) {
            if (DI[i] > BS) {
                System.out.print("\nOverflow occurs for " + DI[i]);
                continue;
            } else if (DI[i] < 0) {
                System.out.print("\nUnderflow occurs for " + DI[i]);
                continue;
            } else {
                System.out.println("\nOutput for " + DI[i] + " is ");
                while (DI[i] != 0) {
                    DI[i] -= rate;
                    System.out.print(rate + "\t");
                    count++;
                }
            }
        }

        System.out.println("\nThe number of packets obtained are :- " + count);
    }
}


