import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {

    //448. Find All Numbers Disappeared in an Array
    //similar to MissingNumber in the same directory
    //Given an array nums of n integers where nums[i] is in the range [1, n],
    // return an array of all the integers in the range [1, n] that do not appear in nums.


    public static List<Integer> missingNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            while (nums[i] != i + 1) {
                int d = nums[i] - 1;
                //sanity check
                if (nums[d] != nums[i]) {
                    swap(nums, i, d);
                } else
                    break;
            }

        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1)
                res.add(i + 1);
        }

        return res;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> l  = missingNumbers(arr);
        System.out.println(l);
    }
}




