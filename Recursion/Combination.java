import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//N Choose K Combinations
//        Given two integers n and k, find all the possible unique combinations of k numbers in range 1 to n.
//        Example One:
//        Input: 5, 2
//        Output: [[1, 2], [1, 3], [1, 4], [1, 5], [2, 3], [2, 4], [2, 5], [3, 4], [3, 5], [4, 5]].

//77 leetCode Combination
public class Combination {

    public static List<String> combination(int n, int k) {
        char[] slate = new char[k];
        List<String> result = new ArrayList<>();
        combinationHelper(n, k, 1, slate, 0, result);
        return result;
    }

    private static void combinationHelper(int n, int k, int startNum, char[] slate, int slateCur, List<String> result) {
        if (slateCur == k) { //backTracking
            result.add(new String(slate,0,k));
            return;
        }

        if (startNum > n) // as we exclude this is a possibility
            return;

        combinationHelper(n , k, startNum + 1, slate, slateCur, result);
        slate[slateCur] = (char)('0'+startNum);
        combinationHelper(n, k, startNum + 1, slate, slateCur+1, result);
    }

    public static void main(String[] args) {
        List<String> s = combination(4,2);
        System.out.println(s);
    }
}



