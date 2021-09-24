import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {
//    Given an integer n, return the number of structurally unique
//    BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

    public int numTrees(int n) {
        if (n <= 0) return 1;
        if (n == 1) return 1;

        return numTreeHelper(n, 1, n);

    }

    private int numTreeHelper(int n, int start, int end) {
        if (start >= end)
            return 1;
        int res = 0;
        for (int i = start; i <= end; i++) {
            res += numTreeHelper(n, start, i - 1) * numTreeHelper(n, i + 1, end);
        }
        return res;

    }

    static long how_many_BSTs(int n) {
        long m = 0;
        if (n <= 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        for (int i = 0; i < n; i++)
            m += how_many_BSTs(i) * how_many_BSTs(n - i - 1);
        return m;
    }

    //Construct all possible BSTs for keys 1 to N

    public static ArrayList<Integer> constructTrees(int start, int end, List<List<Integer> result>) {
        ArrayList<Integer> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            /*  constructing left subtree   */
            ArrayList<Integer> leftSubtree = constructTrees(start, i - 1, result);

            /*  constructing right subtree  */
            ArrayList<Integer> rightSubtree = constructTrees(i + 1, end, result);

            /*  now looping through all left and right subtrees and connecting
                them to ith root  below  */
            list.add(start);
            for (int j = 0; j < leftSubtree.size(); j++) {
                list.add(leftSubtree.get(j));
                for (int k = 0; k < rightSubtree.size(); k++) {
                    list.add(rightSubtree.get(k))
                }
            }
            result.add(list);
            return list;
        }
    }
}


