import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// complexity is b ^ h ; in here TC is n! * n otherwise n ^ n
//SC is O(n) + o(n) + n! * n


//[[
//"--q-",
//"---q",
//"---q",
//"-q--"
//], [
//"-q--",
//"---q",
//"q---",
//"--q-"
//]]

public class NQueens {
    public static List<List<String>> result = new ArrayList<>();
    public static int counter = 0;

    public static String[][] solveNQueens(int n) {

        List<Integer> board = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            board.add(i);
        solveNQueensHelper(0, board);
        String[][] s = new String[result.size()][n];
        for(int i=0; i <result.size(); i++) {
            for(int j =0; j <n; j++) {
                s[i][j]=result.get(i).get(j);
            }
        }
        return s;
    }

    private static void solveNQueensHelper(int i, List<Integer> board) {

        if (i == board.size()) {
            counter++;
            List<String> l = new ArrayList<>();

            for(int k = 0; k < board.size(); k++) {
                int col = board.get(k);
                StringBuilder sb = new StringBuilder();
                for(int e = 0; e < board.size(); e++) {
                    if(e!= col)
                        sb.append("-");
                    else
                        sb.append("q");
                }
                l.add(sb.toString());
            }
            result.add(l);
        }

        for (int j = i; j < board.size(); j++) {
            swapMe(board, i, j);
            if(isValid(i, board))
                solveNQueensHelper(i + 1, board);
            swapMe(board, i, j);
        }
    }

    private static boolean isValid(int i, List<Integer> board) {
        for (int c = 0; c < i; c++) {
            int rowDiff = Math.abs(i - c);
            int colDiff = Math.abs(board.get(i) - board.get(c));
            if (rowDiff == colDiff) return false;
        }
        return true;
    }

    private static void swapMe(List<Integer> board, int idx1, int idx2) {
        int temp = board.get(idx1);
        board.set(idx1,board.get(idx2));
        board.set(idx2,temp);
    }

    public static void main(String[] args) {
        solveNQueens(8);
        System.out.println(result);
        System.out.println(counter);
    }
}
