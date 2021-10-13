public class RangSumQuery {
    //Given an integer array nums, handle multiple queries of the following type:
    //
    //Calculate the sum of the elements of nums between indices left and right
    // inclusive where left <= right.
    //leetcode 303 
    //TC = 0(n)
    //SC = o(n);

    private int[] runningSum;

    public void NumArray(int[] nums) {
        runningSum = new int[nums.length];
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            runningSum[i] = prefixSum;
        }
    }

    public int rangSumQuery(int left, int right) {
        if(left == 0) return runningSum[right];

        return runningSum[right] - runningSum[left-1];
    }



}
