public class WiggleSort {
    // 280 wiggle sort
    //Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
    //
    //You may assume the input array always has a valid answer.
    //TC = O(n)
    //SC = O(1)

    public static void wiggleSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 != 0) { // i is odd
                if (nums[i] <= nums[i + 1]) {
                    swap(nums, i, i + 1);
                    continue;
                }
            } else {
                if (nums[i] >= nums[i + 1]) {
                    swap(nums, i, i + 1);
                    continue;
                }

            }
        }
    }

    private static void swap(int[] num, int idx1, int idx2) {
        int temp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = temp;
    }


}




