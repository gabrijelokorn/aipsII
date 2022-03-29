import java.util.*;
import java.io.*;

public class DivideAndConquer {
    
    static int divideAndConquer (int[] arr, int l, int r) {
        
        if (l == r) {
            System.out.println("[" + arr[l] + "]: " + arr[l]);
            return arr[l];
        }

        int leftValue = divideAndConquer(arr, l, (l + r) / 2);
        int rightValue = divideAndConquer(arr, ((l + r) / 2) + 1, r);

        int mean = (l + r) / 2;
        int combined = arr[mean] + arr[mean + 1];
        int maxCombined = combined;

        for (int i = (l + r) / 2 - 1; i >= l; i--) {
            combined += arr[i];
            if (combined > maxCombined) {
                maxCombined = combined;
            }
        }
        
        combined = maxCombined;
        
        for (int i = ((l + r) / 2) + 2; i <= r; i++) {
            combined += arr[i];
            if (combined > maxCombined) {
                maxCombined = combined;
            }
        }

        int max = (leftValue > rightValue ? leftValue : rightValue);

        max = max > maxCombined ? max : maxCombined;

        System.out.print("[");
        for (int i = l; i <= r; i++) {
            System.out.print(arr[i]);
            if (i < r) 
            System.out.print(", ");

        }
        System.out.print("]");
        System.out.print(": " + max);
        System.out.print("\n");

        return max;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        String[] inputCut = input.split(" ");

        int n = inputCut.length;
        
        int[] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] =  Integer.parseInt(inputCut[i]);
        }

        divideAndConquer(arr, 0, n - 1);
    }
}
