import java.util.ArrayList;
import java.util.List;
//46 leetcode
//sc = n + n.n! + n *n!
//TC = n * n!
public class Permutation {

    public static List<List<Integer>> permutation(int[] nums) {
        List<Integer> slate = new ArrayList<>(nums.length);
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, slate, result);
        return result;
    }

    public static void permuteHelper(int[] nums, int numsIdx, List<Integer> slate, List<List<Integer>> result) {
        if (nums.length == numsIdx) {
            result.add(new ArrayList<>(slate));
            return;
        }
        for (int i = numsIdx; i < nums.length; i++) {
            swap(nums, i, numsIdx);
            slate.add(nums[numsIdx]);
            permuteHelper(nums, numsIdx + 1, slate, result);
            swap(nums, i, numsIdx);
            slate.remove(slate.size() - 1);
        }
    }

    public static void swap(int[] nums, int v1, int v2) {
        int temp = nums[v2];
        nums[v2]= nums[v1];
        nums[v1] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        result = permutation(nums);
        System.out.println(result);

    }

}
