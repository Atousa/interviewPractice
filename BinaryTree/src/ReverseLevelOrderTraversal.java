import java.util.*;

public class ReverseLevelOrderTraversal {

    public static List<List<Integer>> reverse_level_order_traversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);


        while (!q.isEmpty()) {
            List<Integer> newList = new ArrayList<>();
            int len = q.size();
            while (len > 0) {
                TreeNode temp = q.poll();
                len--;
                newList.add(temp.getData());
                if (temp.getLeftNode() != null)
                    q.add(temp.getLeftNode());
                if (temp.getRightNode() != null)
                    q.add(temp.getRightNode());
            }
            res.add(newList);
        }
        Collections.reverse(res);
        return res;
    }
}


