import java.util.*;

public class Urejanje {
    
    static void arrayScribe (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int bubbleSort (int[] arr) {

        int NumberOfOperations = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                NumberOfOperations++;
                if (arr[j - 1] > arr[j]) {
                    NumberOfOperations += 2;
                    int auxiliary = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = auxiliary;
                }
            }
        }

        return NumberOfOperations;
    }

    static int selectionSort (int[] arr) {

        int NumberOfOperations = 0;

        for (int i = 0; i < arr.length; i++) {
            int auxiliary = arr[i];
            int minInx = i;
            int min = auxiliary;

            for (int j = i; j < arr.length; j++) {
                NumberOfOperations++;
                if (arr[j] < min) {
                    NumberOfOperations += 2;
                    minInx = j;
                    min = arr[j];
                }
            }

            arr[i] = arr[minInx];
            arr[minInx] = auxiliary;
        }
        return NumberOfOperations;
    }

    static int insertionSort (int[] arr) {

        int NumberOfOperations = 0;

        for (int i = 1; i < arr.length; i++) {
            int auxiliary = arr[i];
            int j = i;
            while(j > 0) {
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
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        
        //int n = sc.nextInt();
        //int[] arr = new int[n];
        
        int n = 8;
        int[] arr = {1, 3, 5, 6, 2, 9, 1, 3};
        
        /*
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        */
        
        arrayScribe(arr);
		//System.out.println("Number Of Operations: " + insertionSort(arr));
		//System.out.println("Number Of Operations: " + bubbleSort(arr));
        System.out.println("Number Of Operations: " + bubbleSort(arr));
        arrayScribe(arr);
    }
}


/*
8
1 3 5 6 2 9 1 3

1 1 2 3 3 5 6 9
*/
