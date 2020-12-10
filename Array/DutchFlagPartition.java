import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DutchFlagPartition {
    private static void dutchFlagPartition(List<Integer> A, int pivot) {
        int smaller = 0;
        int equal = 0;
        int larger = A.size() - 1;

        while (equal < larger) {
            if (A.get(equal) < pivot) {
                Collections.swap(A, equal++,smaller++);
            } else if (A.get(equal) == pivot)
                equal++;
            else {
                Collections.swap(A, larger--, equal);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>() {{
            add(70);
            add(10);
            add(11);
            add(13);
            add(15);
            add(11);
            add(23);
        }};
        dutchFlagPartition(myList, 11);
        System.out.println(myList);
    }
}





