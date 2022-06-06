/*
INPUT za primer iz učilnce
6 
10
0 1 1
1 3 2 
3 0 2 
1 2 5
1 5 7 
3 2 1 
3 4 4 
2 5 1 
5 4 1 
4 3 3
*/

import java.util.*;

public class Izziv_12 {
    
    public static void main (String[] args) {
        
        Scanner sc = new Scanner (System.in);

        int N = sc.nextInt();
        // M je število povezav (v testnem primeru na učilnici je to 10)
        int M = sc.nextInt();
        int[][] array = new int[M][3];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int recent[] = new int[N];
        int newer[] = new int[N];

        recent[0] = 0;
        newer[0] = 0;
        for (int i = 1; i < N; i++) {
            recent[i] = Integer.MAX_VALUE;
            newer[i] = Integer.MAX_VALUE;
        }

        int count = 0;
        while (true) {
            
            for (int i = 0; i < N; i++) {
                if (newer[i] == Integer.MAX_VALUE) {
                    System.out.printf("Inf");
                    if (i + 1 < N) System.out.printf(" ");
                    continue;
                }
                System.out.printf("%d", newer[i]);
                if (i + 1 < N) System.out.printf(" ");
            }
            
            for (int i = 0; i < N; i++) {
                int oldRoute = recent[i];

                for (int k = 0; k < M; k++) {
                    if (array[k][1] == i) {
                        int beginState = array[k][0];
                        if (recent[beginState] != Integer.MAX_VALUE && beginState != i) {
                            int trying = recent[beginState] + array[k][2];
                            if (trying < oldRoute) {
                                oldRoute = trying;
                                newer[i] = trying;
                            }
                        }
                    }
                }

            }
            
            System.out.printf("\n");

            boolean same = true;
            for (int i = 0; i < N; i++) {
                if (recent[i] != newer[i]) same = false;
                recent[i] = newer[i];
            }
            if (same) {
                //System.out.printf("Exit Point 1\n");
                break;
            }
            
            //count++;
            if (count > 2) {
                //System.out.printf("Exit Point 2\n");
                break;
            }
        }

        /*
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.printf("\n");
        }
        */

    }
}
