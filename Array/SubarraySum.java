import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    //560. Subarray Sum Equals K

    //Given an array of integers nums and an integer k, return the total number of continuous
    // subarrays whose sum equals to k.

    //TC = o(n);

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> hm = new HashMap<>();
        //hm.put(0, 1);
        int globalCount = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k)
                globalCount++;

            int temp = prefixSum - k;
            if (hm.containsKey(temp)) {
                globalCount += hm.get(temp);
            }

            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }
        return globalCount;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1};
        System.out.println(subarraySum(nums,2));

    }


}

