import java.security.AlgorithmConstraints;
import java.util.*;

public class Karatsuba {
    
    static int B = 10;

    static int size (int x) {
        return (int) (Math.log10(x) + 1);
    }

    static int karatsuba (int a, int b) {
        if (a < B || b < B) {
            return a * b;
        } else {
            int n = size(a) <= size(b) ? size(a) : size(b);
            int m = n / 2;

            int aL = a / (int) Math.pow(10, m);
            int aD = a % (int) Math.pow(10, m);
            int bL = b / (int) Math.pow(10, m);
            int bD = b % (int) Math.pow(10, m);

            int z0 = karatsuba(aD, bD);
            int z2 = karatsuba(aL, bL);
            int z1 = karatsuba(aL + aD, bL + bD) - z2 - z0;
            
            return (((int) (Math.pow(10, 2 * m) * z2)) + ((int) (Math.pow(10, m) * z1))) + z0;

        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vnesite dve števili, ločeni s presledkom: ");

        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = karatsuba(a, b);
        System.out.println(c + " =?= " + a * b);
    }
}