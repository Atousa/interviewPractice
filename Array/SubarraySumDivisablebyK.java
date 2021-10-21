import java.util.HashMap;

public class SubarraySumDivisablebyK {

    //974. Subarray Sums Divisible by K
    //Given an array of integers nums and an integer k,
    // return the total number of continuous subarrays whose sum equals to k.

    //TC = o(n)

    public static int subarraysDivByK(int[] nums, int K) {
        if (nums == null || nums.length == 0) return 0;

        public int subarraysDivByK ( int[] nums, int K){
            if (nums == null || nums.length == 0) return 0;

            int globalCount = 0;
            int prefixSum = 0;

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);           //Freq of 0 as remainder is 1

            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
                int temp = prefixSum % K;

                if (temp < 0) temp += K; // negative number can give us a subarray

                if (map.containsKey(temp)) { // because the residue of i and residue of j [i,j] will canceal our and we only have nk that
                    // is divisable by k
                    globalCount += map.get(temp);
                }
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            return globalCount;
        }
    }
}
