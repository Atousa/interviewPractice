import java.util.*;
//if an undirected graph is a valid tree

// time complexity will be o(v+e) + o(v+e)
//space complexity o(n) + o(v)

public class GraphIsTree {

    static List<List<Integer>> adjacencyList = new ArrayList<>();

    private static void buildAdjacencyList(int n, int[][] edges) {

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
    }


    public static boolean graphIsTree(int n, int[][] edges) {

        buildAdjacencyList(n, edges);
        Set<Integer> isVisited = new HashSet<>();
        return (!hasCycle(n-1, isVisited, -1) && isConnected(n, isVisited));
    }

    private static boolean isConnected(int n, Set<Integer> isVisited) {
        return (isVisited.size() == n);
    }

    private static boolean hasCycle(int n, Set<Integer> isVisited, Integer parent) {
        isVisited.add(n);

        for(int l: adjacencyList.get(n)) {
            if(isVisited.contains(l) && l != parent){
                return true;
            }
            if(!isVisited.contains(l)) {
                return (hasCycle(l,isVisited,n));
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{1,4}};
        boolean b = graphIsTree(5,edges);
        System.out.println(b);
    }
}




