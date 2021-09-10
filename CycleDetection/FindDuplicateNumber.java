public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = cal(nums, slow);
            fast = cal(nums, cal(nums, fast));

            if (slow == fast) {
                int third = 0;
                while (third != slow) {
                    slow = cal(nums, slow);
                    third = cal(nums, third);
                }
                return slow;

            }
        }

    }


    private static int cal(int[] nums, int idx){
        return nums[idx];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,2};
        int l = findDuplicate(arr);
        System.out.println(l);



    }
}




