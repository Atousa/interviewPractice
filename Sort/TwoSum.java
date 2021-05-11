import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.abs;

public class TwoSum {

    // array is not sorted, includes negative number
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> h = new HashMap<>();
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (h.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = h.get(target - nums[i]);
                return result;
            } else {
                h.put(nums[i], i);
            }
        }
        return result;
    }

    public static int[] twoSumSorted(int[] nums, int target) {
       int i = 0; int j = nums.length-1;
       int[] result = new int[2];
       while ( i < j) {
           if(nums[i] + nums[j] == target) {
               result[0] = i;
               result[1] = j;
               return result;
           }
           if(nums[i] + nums[j] > target) {
               j--;
           } else
               i++;
       }
       return result;
    }


    public static void main(String[] args) {
        int[] arr = {3,2,-3,1};
        int[] arr2 = {2,7,11,15};
        //int[] result = twoSum(arr,0);
        int[] result = twoSumSorted(arr2,9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }




    // array is sorted
}
