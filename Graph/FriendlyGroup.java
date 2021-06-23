import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FriendlyGroup {
//    here are n people living in a town. Some of them dislike each other. Given the value of n and the pairs of people disliking each other, check if we can divide the people of the town into two sets such that each person belongs to exactly one set and no two persons disliking each other belong to the same set.
//    Example One:
//    Input: n: 5, Disliking pairs: (0, 2) (1, 2) (1, 4) (2, 3) (3, 4).
//    Output: True
//    The people can be partitioned into two sets [0, 1, 3] and [2, 4].

    public static boolean can_be_divided(int num_of_people, List<Integer> dislike1, List<Integer> dislike2){

        int[] visited = new int[num_of_people];
        int[] parent = new int[num_of_people];
        int[] color = new int[num_of_people];

        Arrays.fill(parent, -1);
        Arrays.fill(color, -1);

        for(int i = 0; i < num_of_people; i++) {
            if(visited[i] == 0) {
                if(!dfsCanDivide(buildGraph(num_of_people, dislike1, dislike2), i, visited, parent, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean dfsCanDivide(List<Integer>[] graph, int node, int[] visited, int[] parent, int[] color) {

        visited[node] = 1;

        if(parent[node] == -1) {
            color[node] = 0;
        }
        else {
            color[node] = 1 - color[parent[node]];
        }

        for(Integer neighbour : graph[node]) {
            if(visited[neighbour] == 0) {
                visited[neighbour] = 1;
                parent[neighbour] = node;
                if(!dfsCanDivide(graph, neighbour, visited, parent, color)) {
                    return false;
                }
            }
            else {
                if(neighbour != parent[node]) {
                    if(color[neighbour] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    private static List<Integer>[] buildGraph(int num_of_people, List<Integer> dislike1, List<Integer> dislike2) {

        List<Integer>[] graph = new ArrayList[num_of_people];

        for(int i = 0; i < num_of_people; i++) {
            graph[i] = new ArrayList();
        }

        for(int i = 0; i < dislike1.size(); i++) {
            graph[dislike1.get(i)].add(dislike2.get(i));
            graph[dislike2.get(i)].add(dislike1.get(i));
        }

        return graph;
    }
    
}
