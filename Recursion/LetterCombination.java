import java.util.*;

public class LetterCombination {

    // complexity is o(3 ^n . n) and space complexity is o(n) + o(n) + o(3 ^n *n) : n is the len of digit

    private static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");


    public static List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) return (new ArrayList<>()) ;
        List<String> result = new ArrayList<>();
        List<Character> slate = new ArrayList<>();
        letterCombinationsHelper(digits, 0, slate, result);
        return result;
    }

    private static void letterCombinationsHelper(String digits, int digitsIdx, List<Character> slate, List<String> result) {
        if (digits.length() == digitsIdx) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : slate)
                sb.append(ch);
            result.add(sb.toString());
            return;
        }

        if (digits.charAt(digitsIdx) == 1) {
            letterCombinationsHelper(digits, digitsIdx + 1, slate, result);
        }

        String let = letters.get(digits.charAt(digitsIdx));
        for (Character l : let.toCharArray()) {
            slate.add(l);
            letterCombinationsHelper(digits, digitsIdx + 1, slate, result);
            slate.remove(slate.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> l = letterCombinations("23");
        System.out.println(l);

    }
}




