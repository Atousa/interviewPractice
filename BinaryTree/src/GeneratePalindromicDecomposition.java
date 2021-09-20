import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Palindromic Decomposition Of A String
//
//        Find all palindromic decompositions of a given string s.
//
//        A palindromic decomposition of string is a decomposition of the string into substrings, such that all those substrings are valid palindromes.
//
//        Example
//        Input: "abracadabra"
//
//        Output: [ "a|b|r|a|c|a|d|a|b|r|a", "a|b|r|a|c|ada|b|r|a", "a|b|r|aca|d|a|b|r|a" ]


public class GeneratePalindromicDecomposition {
    static String[] generate_palindromic_decompositions(String s) {
        List<String> result = new ArrayList<>();
        String[][] palindromeMap = new String[s.length()][s.length()];
        generate_palindromic_decompositions_recursive(s.toCharArray(), result, new char[s.length() * 2], 0, 0, palindromeMap);
        return result.toArray(new String[result.size()]);
    }

    static void generate_palindromic_decompositions_recursive(char[] s, List<String> result, char[] slate, int index, int slateIx, String[][] palindromeMap) {
        if (index >= s.length) {
            result.add(new String(slate, 0, slateIx - 1));
            return;
        }
        for (int i = index; i < s.length; i++) {
            slate[slateIx++] = s[i];
            if (isPalindrome(s, index, i, palindromeMap) == "Y") {
                slate[slateIx] = '|';
                generate_palindromic_decompositions_recursive(s, result, slate, i + 1, slateIx + 1, palindromeMap);
            }
        }
    }

    static String isPalindrome(char[] s, int left, int right, String[][] palindromeMap) {
        if (palindromeMap[left][right] != null) {
            return palindromeMap[left][right];
        }
        String result = "Y";
        while (left < right) {
            if (s[left] != s[right]) {
                result = "N";
                break;
            }
            left++;
            right--;
        }
        palindromeMap[left][right] = result;
        return result;
    }















}


}
