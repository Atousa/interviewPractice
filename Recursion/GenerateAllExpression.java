import java.util.ArrayList;
import java.util.List;

//Generate All Possible Expressions That Evaluate To The Given Target Value
//
//        Given a string s that consists of digits (“0”..”9”) and target, a non-negative integer, find all expressions that can be built from string s that evaluate to the target.
//        When building expressions, you have to insert one of the following operators between each pair of consecutive characters in s: “join” or “*” or “+”. For example, by inserting different operators between the two characters of string “12” we can get either 12 (1 joined with 2) or 2 (1*2) or 3 (1+2).
//        Other operators such as  “÷” are NOT supported.
//        Expressions that evaluate to the target but only utilize a part of s do not count: entire s has to be consumed.
//        Precedence of the operators is conventional: “join” has the highest precedence, “*” – medium and “+” has the lowest precedence. For example, 1+2*34=(1+(2*(34)))=1+68=69.
//        You have to return ALL expressions that can be built from string s and evaluate to the target.
//
//        Example One
//        Input:
//        s="222", target=24.

// complexity
//TC = O( 4 ^ n-1) * n
//SC = O(n) + O(1)*n + O( 4 ^ n-1) * n

public class GenerateAllExpression {
  //1 0 5 ; 5
    public static String[] addOperators(String s, long target) {

        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res.toArray(new String[0]);
        char[] path = new char[s.length()*2];
        char[] digits = s.toCharArray();
        long n = 0;
        for(int i = 0; i < digits.length; i++) {
            n = n * 10 + (digits[i] - '0');
            path[i] = digits[i];
            helper(res, path, digits, i+1, i+1, 0, n, target);
        }
        String[] exp = new String[res.size()];
        exp = res.toArray(exp);
        return exp;
    }


    static void helper(List<String> res, char[] path, char[] digits, int idx, int length, long prev, long curr, long target) {
        if(idx == digits.length) {
            if(curr + prev == target) {
                res.add(new String(path, 0 , length));
            }
        } else {
            long n = 0;
            int j = length+1;
            for(int i = idx; i < digits.length; i++) {
                n = n * 10 + (digits[i]-'0');
                path[j++] = digits[i];
                path[length] = '*';
                helper(res, path, digits, i+1,j, prev,curr*n, target);
                path[length] = '+';
                helper(res, path, digits, i+1,j, prev+curr ,n, target);
                path[length] = '-';
                helper(res, path, digits, i+1,j, prev+curr ,-n, target);
            }
        }
    }

    public static void main(String[] args) {
        String num = "12306";
        int target = 15;
        String[] str = addOperators(num,target);

        for (String s: str){
            System.out.println(s);
        }
    }

}
