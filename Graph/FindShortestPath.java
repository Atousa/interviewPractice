
/*
 * Complete the function below.
 */

//Given a two-dimensional maze represented by a character grid, find the shortest path from start to goal cell. You can move vertically or horizontally—but not diagonally—one step at a time.
//        There are six types of cells:
//
//        There’s exactly one start and one goal cell. Other cells may appear any number of times. Water can never be visited. A door cell can only be visited after visiting a matching key, e.g. key ‘a’ for door ‘A’. Other cells can be visited unconditionally. It is allowed to visit a cell more than once.
//
//        Example
//        Input is a list of strings:
//        ["...B",
//        ".b#.",
//     "@#+."]
static class Node {
    int x;
    int y;
    int keys;
    Node prev;
    public Node(int x, int y, Node prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
    }
}
    private static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] find_shortest_path(String[] grid) {
        char[][] matrix = getMatrix(grid);
        int m = matrix.length;
        int n = matrix[0].length;
        int x = -1;
        int y = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '@') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        List<int[]> result = helper(matrix, x, y);
        return result.toArray(new int[result.size()][]);
    }
    private static List<int[]> helper(char[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][][] visited = new boolean[m][n][1 << 10];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(row, col, null));
        visited[row][col][0] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int[] dir : DIRS) {
                int x = cur.x + dir[0];
                int y = cur.y + dir[1];
                Node next = new Node(x, y, cur);
                if (!isValid(matrix, x, y, cur, next)) {
                    continue;
                }
                if (matrix[x][y] == '+') {
                    List<int[]> result = new ArrayList<>();
                    result.add(new int[] {x, y});
                    while (cur != null) {
                        result.add(new int[] {cur.x, cur.y});
                        cur = cur.prev;
                    }
                    Collections.reverse(result);
                    return result;
                }
                if (!visited[x][y][next.keys]) {
                    queue.offer(next);
                    visited[x][y][next.keys] = true;
                }
            }
        }
        return new ArrayList<int[]>();
    }
    private static boolean isValid(char[][] matrix, int x, int y, Node cur, Node next) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == '#') {
            return false;
        }
        if (matrix[x][y] >= 'A' && matrix[x][y] <= 'J') {
            if ((cur.keys >> (matrix[x][y] - 'A') & 1) == 0) {
                return false;
            }
        }
        next.keys = cur.keys;
        if (matrix[x][y] >= 'a' && matrix[x][y] <= 'j') {
            int nextKeys = (1 << (matrix[x][y] - 'a'));
            next.keys |= nextKeys;
        }
        return true;
    }
    private static char[][] getMatrix(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = grid[i].charAt(j);
            }
        }
        return matrix;
    }

