import java.util.ArrayList;
import java.util.List;


//https://www.youtube.com/watch?v=4ykBXGbonlA
public class PrintPalindromicPartition {

//    Palindromic Decomposition Of A String
//
//    Find all palindromic decompositions of a given string s.
//
//    A palindromic decomposition of string is a decomposition of the string into substrings, such that all those substrings are valid palindromes.
//
//    Example
//    Input: "abracadabra"
//
//    Output: [ "a|b|r|a|c|a|d|a|b|r|a", "a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a" ]




    public static String[] generate_palindromic_decompositions(String s) {
        List<String> slate = new ArrayList<>();
        List<String>  result = new ArrayList<>();
        helper(s, 0, slate, result);
        String[] array = result.toArray(new String[0]);
        return array;
    }

    private static void helper(String s, int idx, List<String> slate, List<String> result) {

        if(idx == s.length()) {
            String p = String.join("|" , slate);
            result.add(p);
            return;
        }

        for(int i = idx; i < s.length();i++) {
            if (isPalindrom(s, idx, i)) {
                slate.add(s.substring(idx, i + 1));
                helper(s, i+1, slate, result);
                slate.remove(slate.size() - 1);
            }
        }
    }

    private static boolean isPalindrom(String s, int from, int to) {
        if(from == to) return true;
        while(from < to) {
            if(s.charAt(from) != s.charAt(to)) return false;
            from++;
            to--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = generate_palindromic_decompositions("abracadabra");
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
