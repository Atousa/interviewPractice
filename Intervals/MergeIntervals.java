import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a,b)->a[0]- b[0]);

            for (int i = 0; i < intervals.length; i++) {
                if(res.size() == 0) {
                    res.add(intervals[0]);
                    continue;
                }
                int[] temp = res.get(res.size()-1);
                if(temp[1] < intervals[i][0]) {
                    res.add(intervals[i]);
                } else {
                    res.remove(res.size()-1);
                    int[] curInterval = new int[2];
                    curInterval[0] = temp[0];
                    curInterval[1] = Math.max(temp[1], intervals[i][1]);
                    res.add(curInterval);
            }
        }

        int[][] p = new int[res.size()][2];
        int i = 0;
        for(int[] l : res) {
            p[i++] = l;
        }
        return p;

    }

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = mergeIntervals(intervals);
        System.out.println(res);
    }
}
