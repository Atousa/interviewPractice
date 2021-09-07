import java.util.ArrayList;
import java.util.List;


//986. Interval List Intersections

// complexity
//SC = O(m + n)
//TC = O(m + n)

//You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and
// secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
//
//        Return the intersection of these two interval lists.
//
//        A closed interval [a, b] (with a <= b) denotes the set of real
//        numbers x with a <= x <= b.
//
//        The intersection of two closed intervals is a set of real numbers that are either empty or r
//        epresented as a closed interval. For example, the intersection of [1, 3] and [2,

public class IntervalListIntersection {

    //firstList = [[0,2],[5,10],[13,23],[24,25]],
    // secondList = [[1,5],[8,12],[15,24],[25,26]]
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;

        int idx1 = 0;
        int idx2 = 0;

        List<int[]> res = new ArrayList<>();

        while (idx1 < len1 && idx2 < len2) {
            int[] temp1 = firstList[idx1];
            int[] temp2 = secondList[idx2];

            // while smaller interval doesnt have a conflict with the bigger we move the smaller index
            if (temp1[0] < temp2[0] && temp1[1] < temp2[0]) {
                idx1++;
            } else if (temp2[0] < temp1[0] && temp2[1] < temp1[0]){
                idx2++;
            } else {
                // conflict
                int[] cur = new int[2];
                cur[0] = Math.max(firstList[idx1][0], secondList[idx2][0]);
                cur[1] = Math.min(firstList[idx1][1], secondList[idx2][1]);
                res.add(cur);

                if (cur[1] == temp1[1])
                    idx1++;
                else
                    idx2++;
            }
        }

        int[][] result = new int[res.size()][2];
        int i = 0;
        for (int[] a : res) {
            result[i++] = a;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] result = intervalIntersection(firstList,secondList);


    }
}





