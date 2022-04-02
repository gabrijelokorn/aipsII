import java.util.*;
import java.io.*;

public class MergeSort {

    static void arrayScribe (int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    static void mergeSort (int[] arr, int n) {
        if (n < 2) return;

        int middle = n / 2;
        int[] l = new int[n - middle];
        int[] r = new int[middle];

        for (int i = 0; i < n - middle; i++) {
            l[i] = arr[i];
        }
        for (int i = n - middle; i < n; i++) {
            r[i - (n - middle)] = arr[i];
        }

        mergeSort(l, n - middle);
        mergeSort(r, middle);

        int index_i = 0;
        int index_j = 0;
        int index_arr = 0;

        while (index_arr < arr.length) {

            if (index_i >= l.length || index_j >= r.length) break;
            
            arr[index_arr] = l[index_i] < r[index_j] ? l[index_i] : r[index_j];
            
            if (l[index_i] < r[index_j]) {
                index_i++;
            } else {
                index_j++;
            }
            index_arr++;
        }

        for (int i = index_arr; i < arr.length ; i++) {
            if (index_i < l.length) {
                arr[i] = l[index_i];
                index_i++;
            }
            if (index_j < r.length) {
                arr[i] = r[index_j];
                index_j++;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, arr.length);
        arrayScribe(arr);
    }
}