import java.util.ArrayList;

public class Sudoku {

//    Given a partially filled two-dimensional array, fill all the unfilled cells such
//    that each row, each column and each 3 x 3 subgrid (as highlighted below by bolder lines) has every digit from 1 to 9 exactly once.
//    Unfilled cells have a value of 0 on the given board.

    public static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        helper(board);
        return board;
    }

    private static boolean helper(ArrayList<ArrayList<Integer>> board) {

        int row = 0;
        int col = 0;
        boolean unfilledCell = false;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).size(); j++) {
                if (board.get(i).get(j) == 0) {
                    row = i;
                    col = j;
                    unfilledCell = true;
                    break;
                }
                if (unfilledCell) {
                    break;
                }
            }
        }
        if (!unfilledCell) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                board.get(row).set(col, i);
                if (helper(board)) {
                    return true;
                } else {
                    board.get(row).set(col, 0);
                }
            }

        }
        return false;
    }

    static boolean isSafe(ArrayList<ArrayList<Integer>> board, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (board.get(row).get(i) == val) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board.get(i).get(col) == val) {
                return false;
            }
        }

        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board.get(i).get(j) == val) {
                    return false;
                }
            }
        }
        return true;
    }
}






