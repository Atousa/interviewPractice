import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumList {
    public static List<Integer> two_sum(List<Integer> numbers, int target) {

        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> hm = new HashMap<>(); // <value, idx>
        int len = numbers.size();

        for(int i = 0; i < len; i++) {
            hm.put(numbers.get(i), i);
        }

        for(int i = 0; i < len; i++) {
            if((hm.containsKey(target - numbers.get(i))) && (hm.get(target - numbers.get(i)) != i) ) {
                result.add(i);
                result.add(hm.get(target - numbers.get(i)));
                return result;
            }
        }
        result.add(-1);
        result.add(-1);
        return result;


    }

}
