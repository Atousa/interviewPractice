import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
//complexity worse case n^2 and average case would be k*n; works well for small input or partially sorted input
    public static void insertionSortItr(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            int curElement = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > curElement) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curElement;
        }
    }

    public static void insertionSortRec(int arr[], int numElement) {
        if(numElement == 0) return;
        insertionSortRec(arr, numElement-1);
        int curElement = arr[numElement];
        int j = numElement-1;
        while(j>=0 && arr[j] > curElement) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = curElement;
        return;
    }

    public static void main(String[] args) {
        int[] a = {23,22,15,16,13,0};
        insertionSortItr(a);
        //insertionSortRec(a, a.length-1);
        for(int i=0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(",");
        }
    }
}




