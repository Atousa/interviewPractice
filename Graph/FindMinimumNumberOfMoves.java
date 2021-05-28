import java.util.*;

//leetcode 1197
//time complexity v = n*n and e = 8 * (n*n)
// space complexity o(e) + isVisited.size()
//111222333 ... so the first path that we reach to the target would be the shortest path (BFS)
public class FindMinimumNumberOfMoves {

    static int[] r = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] c = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static int findMinimumNumberOfMovesBFS(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {

        if (start_row == end_row && start_col == end_col) return 0;

        Map<String, Integer> isVisited = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start_row, start_col});
        int step = 0;
        isVisited.put(start_row + "," + start_col, step);

        while (!q.isEmpty()) {
            int qSize = q.size();
            ++step;
            for (int i = 0; i < qSize; i++) {
                int[] pos = q.remove();
                for (int k = 0; k < r.length; k++) {
                    int newRow = r[k] + pos[0];
                    int newCol = c[k] + pos[1];
                    if(isValid(newRow, newCol, rows, cols) && !isVisited.containsKey(newRow+","+newCol)) {
                        isVisited.put(newRow + "'" + newCol, step);
                        q.add(new int[]{newRow, newCol});
                        if (newRow == end_row && newCol == end_col) return isVisited.get(newRow + "'" + newCol);
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int r, int c, int rows, int cols) {
        return ( r < rows && r >=0 && c < cols && c >= 0);
    }

    public static void main(String[] args) {
        int b1 = findMinimumNumberOfMovesBFS(5,5,0,0,4,0);
        System.out.println(b1);
    }

}
