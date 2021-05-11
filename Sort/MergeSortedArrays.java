import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {
   // arr1 of size n, which contains n positive integers sorted in the ascending order.
   // arr2 of size (2*n)


    public static void mergeSortedArrays2(int[] arr1, int[] arr2) {

        int len1 = arr1.length;
        int len2 = arr2.length;
        
        int e1 = len1 - 1;
        int e2 = e1;
        int k = 2 * len1 - 1;

        while (e1 >= 0 && e2 >= 0) {
            if (arr1[e1] > arr2[e2]) {
                arr2[k--] = arr1[e1--];
            } else {
                arr2[k--] = arr2[e2--];
            }
        }
        while (e1 >= 0) {
            arr2[k--] = arr1[e1--];
        }
    }


    public static void main(String[] args) {

        int[] arr1 = {1,5,7,8};
        int[] arr2 = {2,5,10,12,0,0,0,0};

        mergeSortedArrays2(arr1,arr2);
        for(int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

    }

}

























