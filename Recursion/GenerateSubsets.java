import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    /**
     * time complexity is 2^n * n/2
     * space complexity n + n + is 2^n * n/2
     */

    static List<List<Integer>> result1 = new ArrayList<>();
    static List<String> result2 = new ArrayList<>();

    private static void generateSubsetsHelper1(int[] arr, int idx, List<Integer> slate) {

        if (idx == arr.length) {
            result1.add(new ArrayList<>(slate));
            return;
        }
        generateSubsetsHelper1(arr, idx + 1, slate);
        slate.add(arr[idx]);
        generateSubsetsHelper1(arr, idx + 1, slate);
        slate.remove(slate.size()-1);
    }


    private static void generateSubsetsHelper2(String s, int idx, char[] slate,int curSl) {
        if (idx == s.length()) {
            result2.add(new String(slate, 0,curSl));
            return;
        }
        generateSubsetsHelper2(s, idx + 1, slate, curSl);
        slate[curSl] = s.charAt(idx);
        generateSubsetsHelper2(s, idx + 1, slate, curSl + 1);
    }

    public static void generateSubsets1(int[] arr) {
        List<Integer> slate = new ArrayList<>();
        generateSubsetsHelper1(arr, 0, slate);
    }

    public static void generateSubsets2(String s) {
        char[] slate = new char[s.length()];
        generateSubsetsHelper2(s, 0, slate, 0);

    }


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        String s = "123";
        generateSubsets1(arr);
        //generateSubsets2(s);
        //System.out.println(result2);
        System.out.println(result1);
    }
}



