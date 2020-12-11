import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * permute the elements of an array
 *
 */

public class ApplyPermutation {

    public static void applyPermutation(List<Integer> perm, List<Integer> A) {
        int s = A.size();

        for(int i = 0; i < s; i++) {
            if( perm.get(i) >= 0 && perm.get(i) != i) {
                Collections.swap(A, perm.get(i), perm.get(perm.get(i)));
                int temp = perm.get(i);
                perm.set(i, perm.get(i) - s);
                perm.set(temp, perm.get(temp) - s);
            }
        }

        System.out.println(perm);
        //restore the perm
        for(int i = 0; i < s; i++) {
            perm.set(i, perm.get(i)+s);
        }

    }

    public static void main(String[] args) {
        List<Integer> perm = new ArrayList<>();
        perm.add(3);
        perm.add(2);
        perm.add(1);
        perm.add(0);

        List<Integer> A = new ArrayList<>();
        A.add(11);
        A.add(3);
        A.add(9);
        A.add(10);

        applyPermutation(perm,A);
        System.out.println(A);
        System.out.println(perm);

    }
}
