import java.util.*;

//leetcode 47 permutation 1, 2
public class PermutationWithDuplicate {


    public static List<List<Integer>> permuteUnique(int[] nums) {

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
       Set<Integer> m = new HashSet<>();
        for (int i = numsIdx; i < nums.length; i++) {
            if (!m.contains(nums[i])) {
                swap2(nums, i, numsIdx);
                slate.add(nums[numsIdx]);
                m.add(nums[numsIdx]);
                permuteHelper(nums, numsIdx+1, slate, result);
                swap2(nums, i, numsIdx);
                slate.remove(slate.size() - 1);
            }
        }
    }

        public static void swap2(int[] nums, int v1, int v2){
            int temp = nums[v2];
            nums[v2] = nums[v1];
            nums[v1] = temp;
        }

        public static void main (String[]args){
            int[] a = {1, 1, 2,2};
            List<List<Integer>> result = permuteUnique(a);
            System.out.println(result);

        }
    }

