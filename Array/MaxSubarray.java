public class MaxSubarray {

    //53. Maximum Subarray
    
    class Solution {
        public int maxSubArray(int[] nums) {
            int globalMax = nums[0];
            int previous = nums[0];

            for(int i = 1; i < nums.length ; i++) {
                previous = Integer.max(nums[i], nums[i] + previous);
                globalMax = Integer.max(globalMax, previous);
            }
            return globalMax;

        }
    }
}
