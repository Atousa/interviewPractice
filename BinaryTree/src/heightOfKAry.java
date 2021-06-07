import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

//bfs , dfs , regular recursion function , if teh tree is wide , dfs is a better solution

public class heightOfKAry {

    static class TreeNode
    {
        int val;
        Vector<TreeNode> children = new Vector<TreeNode>(0);
    };

    static int find_height(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int height = -1;
        q.add(root);

        while(!q.isEmpty()) {
            int len = q.size();
            height++;
            for(int i = 0; i < len; i++) {
                TreeNode temp = q.poll();
                for(TreeNode child: temp.children){
                    q.add(child);
                }
            }
        }
        return height;
    }

}
