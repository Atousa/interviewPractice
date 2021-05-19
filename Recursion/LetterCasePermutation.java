import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    // given a string s, each letter can be lower case or upper case to create another string

    static List<String> result  = new ArrayList<>();

    /**
     *
     * @param s
     * @param cur
     * @param slate
     * this version is with string and string is immutable, the space complexity is input space complexity (length of slate o(n) + implicit
     * stack space from recursion o(n^2) since in each activation record we create an string 1+2+3+...+n and  the output space complexity that
     * would be 2^n .n.
     * time complexity for the leaf nodes that are 2^n is constant since they dont do anything , for internal nodes , specifically the nodes
     * above the leaf nodes that do majority of work will be 2^n * n since they create string size n . so (2^n .n)
     */
    private static void letterCasePermutationHelper1(String s, int cur, String slate) {

        if(cur == s.length()) {
            result.add(slate);
            return;
        }

        if(Character.isDigit(s.charAt(cur))){
            letterCasePermutationHelper1(s,cur+1,slate+s.charAt(cur));
        } else {
            //Character c = Character.toLowerCase(s.charAt(cur));
            letterCasePermutationHelper1(s,cur+1, slate + Character.toLowerCase(s.charAt(cur)));
            //c = Character.toUpperCase(s.charAt(cur));
            letterCasePermutationHelper1(s,cur+1,slate + Character.toUpperCase(s.charAt(cur)));
        }
    }

    /**
     *
     * @param s
     * @param cur
     * @param slate
     * space complexity is o(2^n . n + n ) and time complexity is 2^n . O(1)
     */
    private static void letterCasePermutationHelper2(String s, int cur, char[] slate) {

        if (cur == s.length()) {
            result.add(new String(slate));
            return;
        }
        if(Character.isDigit(s.charAt(cur))){
            slate[cur] = s.charAt(cur);
            letterCasePermutationHelper2(s,cur+1,slate);
        } else {
            slate[cur] = Character.toLowerCase(s.charAt(cur));
            letterCasePermutationHelper2(s,cur+1, slate);
            slate[cur] = Character.toUpperCase(s.charAt(cur));
            letterCasePermutationHelper2(s,cur+1,slate);
        }

    }
    private static void letterCasePermutationHelper3(String s, int cur, List<Character> slate2) {

        if (cur == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(char c : slate2)
                sb.append(c);
            result.add(sb.toString());
            return;
        }

        if(Character.isDigit(s.charAt(cur))){
            slate2.add(s.charAt(cur));
            letterCasePermutationHelper3(s,cur+1,slate2);
            slate2.remove(slate2.size()-1);
        } else {
            slate2.add(Character.toLowerCase(s.charAt(cur)));
            letterCasePermutationHelper3(s,cur+1, slate2);
            slate2.remove(slate2.size()-1);
            slate2.add(Character.toUpperCase(s.charAt(cur)));
            letterCasePermutationHelper3(s,cur+1,slate2);
            slate2.remove(slate2.size()-1);
        }

    }

    public static void letterCasePermutation(String s) {
        //letterCasePermutationHelper1(s, 0,"");
//        char[] slate = new char[s.length()];
//        letterCasePermutationHelper2(s, 0,slate);
//        System.out.println(result);
        List<Character> slate2 = new ArrayList<>();
        letterCasePermutationHelper3(s, 0,slate2);
        System.out.println(result);

    }

    public static void main(String[] args) {
        String s = "a1b2";
        letterCasePermutation(s);
    }

}
