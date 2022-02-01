public class WiggleSort {
    //leetcode 280, 324

//    Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
//    You may assume the input array always has a valid answer.
//
//
//
//            Example 1:
//
//    Input: nums = [1,5,1,1,6,4]
//    Output: [1,6,1,5,1,4]
//    Explanation: [1,4,1,5,1,6] is also accepted.

    //Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?

    public void wiggleSort(int[] nums) {


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
