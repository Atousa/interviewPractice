import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//leetcode 215
//quickSelect
public class KthLargestElement {

    public static void kthLargestElement(int[] arr, int k) {
        int len = arr.length;
        kthLargestElementHelper(arr, 0, len - 1, k);
        for (int i = len - k; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void kthLargestElementHelper(int[] arr, int s, int e, int k) {

        if( s == arr.length-k) return;
        int pivotIdx = partition(arr, s, e);
        if (pivotIdx <= arr.length - k) {
            kthLargestElementHelper(arr, pivotIdx, e, k);
        }else {
            kthLargestElementHelper(arr, s, pivotIdx, k);
        }
    }

    private static int partition(int[] arr, int s, int e) {
        Random rnd = new Random();
        int range = e - s + 1;
        int pivotIdx = rnd.nextInt(range) + s;
        SwapElement.swapElement(arr, pivotIdx, s);
        int pivot = arr[s];

        int smaller = s;
        int greater = s;

        while(greater <= e) {
            if(arr[greater] < pivot) {
                smaller++;
                SwapElement.swapElement(arr,smaller, greater);
            }
            greater++;
        }
        SwapElement.swapElement(arr, smaller,s);
        return (smaller);
    }

    public static void main(String[] args) {
        int[] arr = {10,11,1,5,3,2,12};
        int k = 3;
        kthLargestElement(arr,3);
    }
}



