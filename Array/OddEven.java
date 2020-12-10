import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sort/grouping odd and even numbers
 */

public class OddEven {
    public static void oddEven(List<Integer> A) {

        int odd = A.size() - 1;
        int even = 0;

        while (even < odd) {
            if (A.get(even) % 2 == 0) {
                even++;
            } else {
                Collections.swap(A, even, odd--);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>(){{
            add(10);
            add(21);
            add(34);
            add(12);
            add(1);
            add(5);
            add(66);
            add(18);
        }};
        oddEven(list);
        System.out.println(list);
    }

}
