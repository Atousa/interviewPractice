import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomUpLevelTraversal {

    public static List<List<Integer>> res = new ArrayList<>();

    public static void bottomUpLevelTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int len = q.size();
            List<Integer> l = new ArrayList<>();
            while(len>0) {
                TreeNode temp = q.poll();
                len--;
                l.add(temp.getData());
                if(temp.getLeftNode()!= null)
                    q.add(temp.getLeftNode());
                if(temp.getRightNode()!=null)
                    q.add(temp.getRightNode());
            }
            res.add(0, l);
        }

    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.setLeftNode(new TreeNode(2));
        tree.setRightNode(new TreeNode(3));
        tree.getLeftNode().setLeftNode(new TreeNode(4));
        tree.getLeftNode().setRightNode(new TreeNode(5));
        tree.getRightNode().setLeftNode(new TreeNode(6));
        bottomUpLevelTraversal(tree);
        System.out.println(res);

    }

}
