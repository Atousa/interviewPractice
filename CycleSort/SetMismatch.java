public class SetMismatch {

    //you have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately,
    // due to some error, one of the numbers in s got duplicated to another number in the set,
    //which results in repetition of one number and loss of another number.

    public int[] setMismatch(int[] nums) {

        int[] res = new int[2];

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            while (nums[i] != i + 1) {
                int d = nums[i] - 1;
                if (nums[d] != nums[i]) {
                    swap(nums, i, d);
                } else
                    break;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
            }
        }
        return res;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    //Tests
//    Input: nums = [1,2,2,4]
//    Output: [2,3]

//    Input: nums = [1,1]
//    Output: [1,2]
}


