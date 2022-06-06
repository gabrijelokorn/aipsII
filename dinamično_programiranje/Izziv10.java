import java.util.*;

public class Izziv10 {
    
    public static int[][] arrayToArray;

    public static void dinamicnoProgramiranje (int n, int k) {
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {

                int max = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
                    int a = arrayToArray[i - 1][l - 1];
                    int b = arrayToArray[i][j - l];
                    max = (1 + (a > b ? a : b)) < max ? (1 + (a > b ? a : b)) : max;
                }
                arrayToArray[i][j] = max;
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        arrayToArray = new int[k + 1][n + 1];
        
        // priprava tabele
        for (int i = 0; i <= k; i++) {
            arrayToArray[i][1] = 1;
        }
        for (int i = 0; i <= n; i++) {
            arrayToArray[1][i] = i;
        }

        dinamicnoProgramiranje(n, k);

        // Arrayscribe

        // najprej samo header
        for (int i = 0; i <= k; i++) {
            if (i == 0) {
                System.out.printf("     ");
            } else {
                System.out.printf("%3d ", i);
            }
        }
        System.out.printf("\n");
        
        // vedno prvi stolpc i
        for (int i = 0; i <= n; i++) {
            System.out.printf("%4d ", i);
            for (int j = 1; j <= k; j++) {
                System.out.printf("%3d ", arrayToArray[j][i]);
            }
            System.out.printf("\n");
        }

        // šezmer nism čist zihr zakaj to dela lol
    }
}
