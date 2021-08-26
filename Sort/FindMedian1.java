import java.util.Collections;
import java.util.Random;

public class FindMedian1 {

    public static int a = -1;
    public static int b = -1;

    public static int findMedian(int[] nums) {
        int len = nums.length;
        int ans;

        if (len % 2 == 0) {
            MedianUtil(nums, 0, len - 1, len / 2);
            ans = (a + b) / 2;
        }
        else {
            MedianUtil(nums, 0, len - 1, len / 2);
            ans = a;
        }
        return ans;
    }


    private static void MedianUtil(int[] nums, int start, int end, int medianIDX) {

        if (start <= end) {

            int pivotIdx = randomPartition(nums, start, end);

            if (pivotIdx == medianIDX) {
                a = nums[pivotIdx];
                if (b != -1) return;
            }
            if (pivotIdx == medianIDX - 1) {
                b = nums[pivotIdx];
                if (a != -1) return;
            }


            if (pivotIdx > medianIDX) {
                MedianUtil(nums, start, pivotIdx - 1, medianIDX);
            } else {
                MedianUtil(nums, pivotIdx + 1, end, medianIDX);
            }
        }
    }

    public static int randomPartition(int arr[], int s, int e){
        Random rnd = new Random();
        int range = e - s + 1;
        int pivotIdx = s + rnd.nextInt(range);
        swap(arr, pivotIdx, s);
        int smaller = s;
        int greater = s;
        int pivot = arr[s];

        while(greater <= e) {
            if (arr[greater] < pivot) {
                smaller++;
                swap(arr, smaller, greater);
            }
            greater++;
        }
        swap(arr, s, smaller);
        return smaller;
    }



    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {11,4,6,7,8,0};
        int m = findMedian(a);
        System.out.println("Median: "+m);
    }


}
