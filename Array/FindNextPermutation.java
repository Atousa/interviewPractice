import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
Compute the next permutation using dictionary ordering
 */

// knowing the fact that the permutation <0,1,2> is the smallest and <2,1,0>
// is the largest under dictionary ordering

public class FindNextPermutation {

    public static List<Integer> FindNextPermutation(List<Integer> perm) {
        //find the entry from teh right that is smaller than the entry
        //immediately after it.

        int idx = perm.size() - 2;

        while (idx >= 0 &&
                perm.get(idx) >= perm.get(idx + 1))
            idx--;

        if(idx == -1) return Collections.emptyList();

        //swap the smallest element that are bigger than perm.get(idx) with the element at the idx.
        //since it is the decreasing order the first entry that is greater than perm.get(idx) would
        // be the right element to swap

        for ( int i = perm.size()-1; i > idx; i--) {
            if (perm.get(i) > perm.get(idx)) {
                Collections.swap(perm, idx, i);
                break;
            }
        }

        // sort the list after teh idx, since it is is already in decreasing order
        //we don't need sorting algorithm. we just reverse the the entries to get the
        //smallest dictionary order

        Collections.reverse((perm.subList(idx+1,perm.size())));

        return perm;
    }

    public static void main(String[] args) {
        List<Integer> perm = new ArrayList<>();
        perm.add(1);
        perm.add(0);
        perm.add(3);
        perm.add(2);
        List<Integer> l = FindNextPermutation(perm);
        System.out.println(l);

        List<Integer> perm2 = new ArrayList<>();
        perm2.add(3);
        perm2.add(2);
        perm2.add(1);
        perm2.add(0);
        List<Integer> l2 = FindNextPermutation(perm2);
        System.out.println(l2);

    }



}
