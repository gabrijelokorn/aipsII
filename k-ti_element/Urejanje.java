import java.util.*;

public class Urejanje {

    static int insertionSort (int[] arr, int r, int s) {

        int NumberOfOperations = 0;

        for (int i = r; i <= s; i++) {
            int auxiliary = arr[i];
            int j = i;
            while(j > r) {
                NumberOfOperations++;
                if (arr[j - 1] > auxiliary) {
                    NumberOfOperations++;
                    arr[j] = arr[j - 1];
                } else break;
                j--;
            }
            arr[j] = auxiliary;
        }
        return NumberOfOperations;
    }

}
