import java.util.*;
import java.io.*;

public class CountSort {

    static void countSort (int[] arr, int[] bin, int[] count32, int[] cs){
        for (int i = arr.length - 1; i >= 0; i--) {
            count32[bin[i]] -= 1;
            cs[count32[bin[i]]] = arr[i];

            System.out.println("(" + arr[i] + "," + count32[bin[i]] + ")");
        }
    }

    static void arrayScribe (int[] arr, int[] bin, int[] count32, int[] cs) {
        /*
        System.out.println("arr: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        System.out.println("bin: ");
        for (int i = 0; i < bin.length; i++) {
            System.out.print(bin[i] + " ");
        }
        System.out.println();
        
        System.out.println("count32: ");
        for (int i = 0; i < count32.length; i++) {
            System.out.print(count32[i] + " ");
        }
        System.out.println();

        System.out.println("cs: ");
        */
        for (int i = 0; i < cs.length; i++) {
            System.out.print(cs[i] + " ");
        }
        System.out.println();
    }

    static int binary (int x) {
        if (x <= 0) {
            return 0;
        }
        return binary (x / 2) + (x % 2 == 1 ? 1 : 0);
    }

    static void binaryCount (int[] arr, int[] bin, int[] count32) {
        for (int i = 0; i < arr.length; i++) {
            int numberOfOnes = binary(arr[i]);
            bin[i] = binary(arr[i]);
            count32[numberOfOnes]++;
        }

        int sum = 0;
        for (int i = 0; i < count32.length; i++) {
            sum += count32[i];
            count32[i] = sum;
        }
    }

    public static void main (String[] args) {

        Scanner sc = new Scanner (System.in);

        int n = sc.nextInt();
        int[] arr = new int [n];
        int[] bin = new int [n];
        int[] count32 = new int [32];
        int[] cs = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        binaryCount(arr, bin, count32);
        countSort(arr, bin, count32, cs);
        arrayScribe(arr, bin, count32, cs);
    }
}