public class MissingNumber {

    //268. Missing Number
    //Given an array nums containing n distinct numbers in the range [0, n],
    // return the only number in the range that is missing from the array.
    // 1. regular one is n(n+1)/2 - sumofvalues

    // consecutive numbers in a range can be solved using cycle sort.

    // complexity TC = 0(n) , SC = 0(1)

    public static int missingNumber(int[] nums) {
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            //while the number is not in the right spot we send the value in teh right place
            while(nums[i] != i) { // for the following input
                int idx = nums[i];
                if(idx < len) { // sanity check
                    SwapElement.swapElement(nums, i, idx);
                } else
                    break;
            }
        }

        for(int i = 0; i < len; i++) {
            if(nums[i] != i) {
                return i;

            }
        }
        return nums.length;
    }


    //Tests

    //Input: nums = [3,0,1], range [0,3]
    //Output: 2

    //Input: nums = [0,1], range [0,2]
   //Output: 2

    //Input: nums = [0] , range [0,1]
    //Output: 1

    //Input: nums = [9,6,4,2,3,5,7,0,1]
    //Output: 8
    public static void main(String[] args) {
        int[] arr = new int[]{9,6,4,2,3,5,7,0,1};
        int a = missingNumber(arr);
        System.out.println(a);

    }

}
