import java.util.*;

public class NumberOfConnectedComponents {
//leetcode 323
    // we create an adjacency list form edges,  then do bfs or dfs in the list
    //time complexity is o(v+e) and space is v


    /** dfs time complexity o(v+e) creating the list + o(n) * o(v);
     *   dfs space complexity o(v+e) creating the list + o(n) isvisited + o(v)
     *
     *   bfs time complexity o(v+e) creating the list + o(n)*0(v+e)
     *   bfs space complexity o(v+e)+ o(n) + o(n)*0(v+e)
     *
     * @param n
     * @param edges
     * @return
     */

    public static int numberOfConnectedComponents(int n, int[][] edges) {

        if (n == 1) return 1;
        if(n == 0) return 0;

        List<List<Integer>> adjacencyList = buildAdjacencyList(n, edges);
        boolean[] isVisited = new boolean[n];
        int counter = 0;
        // dfs
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                counter++;
                dfs(isVisited, adjacencyList, i);
            }
        }
        return counter;
    }

    private static void dfs(boolean[] isVisited, List<List<Integer>> adjacencyList, int idx) {
        isVisited[idx] = true;
        for (int l : adjacencyList.get(idx)) {
            if (!isVisited[l]) {
                dfs(isVisited, adjacencyList, l);
            }
        }

    }

    private static List<List<Integer>> buildAdjacencyList(int n, int[][] edges) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int k = 0;

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);

        }

        return adjacencyList;
    }


    private static int bfsCountComponents(int n, int[][] edges) {

        List<List<Integer>> adjacencyList = buildAdjacencyList(n, edges);

        boolean[] isVisited = new boolean[n];
        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                counter++;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(0);
                while (!q.isEmpty()) {
                    int idx = q.poll();
                    isVisited[idx] = true;
                    for (int next : adjacencyList.get(idx)) { // should return a list ?
                        if (!isVisited[idx]) {
                            q.offer(next);
                        }
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{3,4}};
        System.out.println(numberOfConnectedComponents(5,edges));

    }
}













