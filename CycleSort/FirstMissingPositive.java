public class FirstMissingPositive {

//    Given an unsorted integer array nums, return the smallest missing positive integer.
//    You must implement an algorithm that runs in O(n) time and uses constant extra space.
    // range is important [1,n] so the smallest number is 1

    public static int firstMissingPositive(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1){
                int d = nums[i]-1;
                //sanity check
                if( d >=0 && d < nums.length && nums[i] != nums[d]) {
                    swap(nums, i, d);
                } else
                    break;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


//    Example 1:
//
//    Input: nums = [1,2,0]
//    Output: 3
//    Example 2:
//
//    Input: nums = [3,4,-1,1]
//    Output: 2
//    Example 3:
//
//    Input: nums = [7,8,9,11,12]
//    Output: 1
    public static void main(String[] args) {
        int[] n= new int[]{1,2,0};
        System.out.println(firstMissingPositive(n));

    }


}
