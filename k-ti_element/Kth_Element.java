import java.util.*;
import java.io.*;

public class Kth_Element {
    
    private static int n_min = 5;
    
    static void arrayScribe (int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
    
    static int median (int start, int end, int[] arr) {
        Urejanje findMed5 = new Urejanje();
        findMed5.insertionSort(arr, start, end);
        return arr[Math.min(start + (end - start) / 2, end)];
    }
    
    static int medianOfMedians (int[] arr, int r, int s) {
        
        int offset = ((s - r + 1) % 5 == 0) ? 0 : 1;
        int[] meds = new int[(s - r + 1) / 5 + offset];

        for (int i = 0; i < meds.length; i++) {
            meds[i] = median(r + i * 5, Math.min(r + i * 5 + 4, s), arr);        
        }
        
        return median(0, meds.length - 1, meds);
    }

    static int bfprt (int k, int[] arr, int r, int s) {
        
        
        if (s - r + 1 <= n_min) {
            Urejanje ur = new Urejanje();
            ur.insertionSort(arr, r, s);
            return arr[r + k];
        } else {
            int pivot = medianOfMedians(arr, r, s);
            int less = 0;
            for (int i = r; i <= s; i++) {
                if (arr[i] <= pivot) less++;
            }
            int more = arr.length - less;

            int j = 0;
            if (less > k) {
                int[] left = new int[less];
                for (int i = r; i < s; i++) {
                    if (arr[i] <= pivot) {
                        left[j] = arr[i];
                        j++;
                    }
                }
                return bfprt(k, left, 0, left.length - 1);
            } else {
                int[] right = new int[arr.length - less];
                for (int i = r; i <= s; i++) {
                    if (arr[i] > pivot) {
                        right[j] = arr[i];
                        j++;
                    }
                }
                return bfprt(k - less, right, 0, right.length - 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(bfprt(k, arr, 0, arr.length - 1));
    }
}

// input cases and solutions:

// first integer is length of unsorted array, second is k
// followed by series of n numbers

// 52 11 16 77 93 86 2 100 47 85 39 92 70 71 87 65 25 86 76 29 25 95 37 94 57 5 43 53 8 80 35 7 3 39 86 2 78 80 38 45 85 58 18 10 24 53 11 89 27 10 4 98 14 74
// 2, 2, 3, 4, 5, 7, 8, 10, 10, 11, >>> 16 <<<, 18, 24, 25, 25, 27, 29, 35, 37, 38, 39, 39, 43, 45, 47, 53, 53, 57, 58, 65, 70, 71, 76, 77, 78, 80, 80, 85, 85, 86, 86, 86, 87, 89, 92, 93, 94, 95, 98, 100
// 16

// 52 27 16 77 93 86 2 100 47 85 39 92 70 71 87 65 25 86 76 29 25 95 37 94 57 5 43 53 8 80 35 7 3 39 86 2 78 80 38 45 85 58 18 10 24 53 11 89 27 10 4 98 14 74
// 2, 2, 3, 4, 5, 7, 8, 10, 10, 11, 16, 18, 24, 25, 25, 27, 29, 35, 37, 38, 39, 39, 43, 45, 47, 53, >>> 53 <<<, 57, 58, 65, 70, 71, 76, 77, 78, 80, 80, 85, 85, 86, 86, 86, 87, 89, 92, 93, 94, 95, 98, 100
// 53

// 35 25 4 8 2 3 1 5 4 7 4 7 9 8 1 3 3 2 4 1 4 10 5 1 4 3 6 6 6 9 10 4 10 6 7 9 8
// 7