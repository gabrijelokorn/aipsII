import java.util.*;
import java.io.*;

public class QuickSort {

    static void arrayOutput (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    static void swap (int[] arr, int i, int j) {
        int auxilary = arr[i];
        arr[i] = arr[j];
        arr[j] = auxilary;
    }

    static void quickSort(int[] arr, int l, int r) {
        // končamo rekurzijo, ko imamo v tabeli enega ali manj elementov
        if (l >= r) return;
        
        // formula za pivot - srednji element
        int pivot = arr[(l + r) / 2];

        int i = l;
        int j = r;

        while (i <= j) {
            while (arr[i] < pivot) {
                i += 1;
            }
            while (arr[j] > pivot) {
                j -= 1;
            }

            if (i <= j) {
                swap(arr, i, j);
                i += 1;
                j -= 1;
            }
        }

        // klic podtabel
        quickSort(arr, l, j);
        quickSort(arr, i, r);
    }

    public static void main (String[] args) {

        int[] arr = {77, 44, 33 ,78, 1, 99, 180, 12, 47, 66, 33};
        arrayOutput(arr);
        
        quickSort(arr, 0, arr.length - 1);
        arrayOutput(arr);
    }
}
