import java.util.ArrayList;
import java.util.List;


// leetcode 969 pancake sorting
public class PancakeSort {

    // Given an array of integers arr, sort the array by performing a series of pancake flips.
    //
    //In one pancake flip we do the following steps:
    //
    //Choose an integer k where 1 <= k <= arr.length.
    //Reverse the sub-array arr[0...k-1] (0-indexed).
    //For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3,
    // we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.
    //
    //Return an array of the k-values corresponding to a sequence of pancake flips that sort arr.
    // \Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.

    //under  2(n-1) operations in worse case
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int numFlips = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            int idx = -1;
            if (arr[i] != i + 1) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] == i + 1) {
                        idx = j;
                        break;
                    }
                }
            }
            if(idx!=-1) {
                int top = 0;
                reverse(arr, top, idx);
                result.add(idx+1);
                reverse(arr, top, i);
                result.add(i+1);
            }
        }
        return result;
    }
    private static void reverse(int[] arr, int idx1, int idx2) {
        while(idx1 < idx2) {
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
            idx1++;
            idx2--;
        }
    }

//    Input: arr = [3,2,4,1]
//    Output: [4,2,4,3]
//    Explanation:
//    We perform 4 pancake flips, with k values 4, 2, 4, and 3.
//    Starting state: arr = [3, 2, 4, 1]
//    After 1st flip (k = 4): arr = [1, 4, 2, 3]
//    After 2nd flip (k = 2): arr = [4, 1, 2, 3]
//    After 3rd flip (k = 4): arr = [3, 2, 1, 4]
//    After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.
//
//[1,3,1,2,1,1,3]
    public static void main(String[] args) {
        int[] arr= new int[]{3,2,4,1};
        List<Integer> l = pancakeSort(arr);
        System.out.println(l);
    }
}







