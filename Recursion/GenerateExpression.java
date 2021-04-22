
import java.util.ArrayList;
import java.util.List;

//282 leetcode with minor difference
//TC = O( 3 ^ n-1) * n
//SC = O(n) + O(1)*n + O( 3 ^ n-1) * n
public class GenerateExpression {

    static public List<String> result = new ArrayList<>();
    static public long target = 24;


    private static void helper(String nums, int idx, List<Character> slate, long target, long curSum, Long curProduct, int curNum) {
        //backTracking
        if(curSum > target)
            return;

        if(idx == nums.length()) {
            if(curSum+curProduct*curNum == target) {
                StringBuilder sb = new StringBuilder();
                for(char i : slate) {
                    sb.append(i);
                }
                result.add(sb.toString());
            }
            return;
        }

        //concatinate
        slate.add(nums.charAt(idx));
        helper(nums,idx+1, slate, target, curSum, curProduct, curNum*10+(nums.charAt(idx) -'0'));
        slate.remove(slate.size()-1);

        //"+"
        slate.add('+');
        slate.add(nums.charAt(idx));
        helper(nums,idx+1, slate, target, curSum+curProduct*curNum, 1L, nums.charAt(idx)-'0');
        slate.remove(slate.size()-1);
        slate.remove(slate.size()-1);

        //*
        slate.add('*');
        slate.add(nums.charAt(idx));
        helper(nums,idx+1, slate, target, curSum, curProduct*curNum, nums.charAt(idx)-'0');
        slate.remove(slate.size()-1);
        slate.remove(slate.size()-1);

    }


    public static void main(String[] args) {
        String nums = "1234";
        List<Character> slate = new ArrayList<>();
        slate.add(nums.charAt(0));
        Long curSum = 0L;
        long curProduct = 1L;
        int idx = 0;
        helper(nums, 1, slate, 11, 0L, 1L, nums.charAt(0)-'0');
        System.out.println(result);
    }

}


