// 2. DISTANCE VECTOR ALGORITHM USING BELLMAN FORD ALGO

import java.util.*;

class DVT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, k;
        System.out.print("Enter number of nodes :-  ");
        int n = sc.nextInt();

        int[][] costmat = new int[10][10];
        int[][] dist = new int[10][10];
        int[][] from = new int[10][10];

        System.out.println("Enter the cost matrix ");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                costmat[i][j] = sc.nextInt();
                dist[i][j] = costmat[i][j];
                from[i][j] = j;  // next-hop or next node to visit
            }
        }

        System.out.println("From matrix is :- ");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                System.out.print(from[i][j] +" ");
            }
            System.out.println("\n");
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                for (k = 1; k <= n; k++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        from[i][j] = k;   // UPDATE 'from' WITH NEW NODE LOCATION
                    }
                }
            }
        }

        for (i = 1; i <= n; i++) {
            System.out.println("\nFrom Router node :- " + i);
            System.out.println("Destination node\tNext-hop\tDistance");
            for (j = 1; j <= n; j++) {
                System.out.println("\t" + j + "\t\t\t\t  " + from[i][j] + "\t\t\t  " + dist[i][j]);
            }
        }
    }
}

