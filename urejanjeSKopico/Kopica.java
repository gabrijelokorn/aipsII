import java.util.*;

public class Kopica {

    static void izpis(int polje[], int dolzina) {
        int stopnja = 2;
        for (int i = 1; i < dolzina; i++) {
            System.out.print(polje[i] + " ");
            if (stopnja == i + 1 && i + 1 < dolzina) {
                System.out.print("| ");
                stopnja *= 2;
            }
        }
        System.out.println();
    }

    static void pogrezni(int a[], int i, int dolzKopice) {
        int index = 0;
        if (i * 2 <= dolzKopice) {
            index = 2 * i;
        }
        if (i * 2 + 1 <= dolzKopice && a[2 * i] < a[2 * i + 1]) {
            index = 2 * i + 1;
        }

        int save = a[i];
        if (index == 0) {
            return;
        } else if (a[i] < a[index]) {
            a[i] = a[index];
            a[index] = save;
            pogrezni(a, index, dolzKopice);
        }
    }


    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 10;

        int[] tabela = {77, 44, 33 ,78, 1, 99, 180, 12, 47, 66, 33};

        /*

        int n = sc.nextInt();
        int[] tabela = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tabela[i] = sc.nextInt();
        }

        for (int i = n / 2; i > 0; i--) {
            pogrezni(tabela, i, n);
        }*/
        
        izpis(tabela, n + 1);

        for (int i = n; i > 0; i--) {
            int save = tabela[i];
            tabela[i] = tabela[1];
            tabela[1] = save;

            pogrezni(tabela, 1, n - (n - i) - 1);
            izpis(tabela, n - (n - i));
        }

    }
};