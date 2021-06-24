import java.util.ArrayList;
import java.util.List;

public class IsTree {

    public static boolean is_it_a_tree(int node_count, List<Integer> edge_start, List<Integer> edge_end) {
        if(node_count == 1) return true;

        int[] visited = new int[node_count];

        List<List<Integer>> adjacencyList = buildAdjacencyList(node_count,edge_start,edge_end);
        return (!hasCycle(adjacencyList,0,-1, visited) && (numElement(visited) == node_count));
    }

    private static List<List<Integer>> buildAdjacencyList(int node_count, List<Integer> edge_start, List<Integer> edge_end){
        List<List<Integer>> adjLst = new ArrayList<>();
        for(int i = 0; i < node_count; i++){
            adjLst.add(new ArrayList<>());
        }

        for(int i = 0; i < edge_start.size(); i++) {
            adjLst.get(edge_start.get(i)).add(edge_end.get(i));
            adjLst.get(edge_end.get(i)).add(edge_start.get(i));
        }
        return adjLst;
    }

    private static boolean hasCycle(List<List<Integer>> adjacencyList, int cur, int curParent,int[] visited) {
        visited[cur] = 1;

        for(int neighbor : adjacencyList.get(cur)) {
            if(visited[neighbor] == 1) {
                if(neighbor != curParent)
                    return true;
            } else {
                if(hasCycle(adjacencyList, neighbor, cur, visited)) // we need this if because when we find the cycle now we want to bubble the answer up
                    return true;
            }
        }
        return false;
    }

    private static int numElement(int[] visited) {
        int counter = 0;
        for(int i = 0 ; i < visited.length; i++) {
            if(visited[i] == 1)
                counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        List<Integer> lStart = new ArrayList<>();
        lStart.add(4);
        lStart.add(4);
        lStart.add(4);
        lStart.add(2);
        lStart.add(1);
        List<Integer> lEnd = new ArrayList<>();
        lEnd.add(3);
        lEnd.add(5);
        lEnd.add(0);
        lEnd.add(0);
        lEnd.add(0);

        boolean b = is_it_a_tree(6, lStart,lEnd);
        System.out.println(b);
    }

//4 3
//4 5
//4 0
//2 0
//1 0

}
