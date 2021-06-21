public class ZombiCluster {

    public static int zombieCluster(List<String> zombies) {
        // Write your code here
        int numRow = zombies.size();
        int numCol = zombies.get(0).length();
        if(numRow != numCol) return -1;
        Set<Integer> visited = new HashSet<>();
        int step = 0;
        for(int i = 0; i < numRow; i++) {
            if(!visited.contains(i)) {
                step++;
                dfs(zombies,i,numRow,numCol,visited);
            }
        }
        return step;
    }

    private static void dfs(List<String> zombies, int cur, int numRow, int numCols, Set<Integer> isVisited) {
        isVisited.add(cur);
        for (int i = cur+1; i < numCols; i++) {
            if(zombies.get(cur).charAt(i)=='1' && !isVisited.contains(i)) {
                dfs(zombies, i, numRow, numCols, isVisited);
            }
        }
        return;
    }
    

}
