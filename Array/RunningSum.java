public class RunningSum {
    // Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    //
    //Return the running sum of nums.
    // leetcode 1480
    // TC = 0(n)

    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            runningSum[i] = prefixSum;
        }
        return runningSum;
    }
}
