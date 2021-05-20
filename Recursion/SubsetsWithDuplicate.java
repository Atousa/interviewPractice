import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode 90
public class SubsetsWithDuplicate {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>>  subsetsWithDuplicate(int[] s) {
        Arrays.sort(s);
        List<Integer> slate = new ArrayList<>();
        subsetsWithDuplicateHelper(s, 0, slate);
        return result;
    }


    private static void subsetsWithDuplicateHelper(int[] s, int idx, List<Integer> slate) {

        if (idx == s.length) {
            result.add(new ArrayList<>(slate));
            return;
        }
        int counter = 1;
        while (idx < s.length-1 && s[idx] == s[idx + 1]) {
            counter++;
            idx++;
        }
        int c = counter;
        subsetsWithDuplicateHelper(s, idx + 1, slate);
        while (c > 0) {
            slate.add(s[idx]);
            subsetsWithDuplicateHelper(s, idx + 1, slate);
            c--;
        }
        while(counter>0) {
            slate.remove(slate.size()-1);
            counter--;
        }
    }

    public static void main(String[] args) {
       int[] c = {1,2,1,1,2};
        subsetsWithDuplicate(c);
        System.out.println(result);
    }
}
