import java.util.*;

public class RightSideOFTree {
    static List<Integer> result = new ArrayList<>();

    public static void rightSideOFTree(TreeNode root) {
        if(root == null) throw new NullPointerException();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>(size);
            while (size > 0) {
                TreeNode temp = q.poll();
                l.add(temp.getData());
                size--;
                if (temp.getLeftNode() != null)
                    q.add(temp.getLeftNode());
                if (temp.getRightNode() != null)
                    q.add(temp.getRightNode());
            }
            result.add(l.get(l.size()-1));
            //result.add(l.get(0)); // left side
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.setLeftNode(new TreeNode(9));
        tree.setRightNode(new TreeNode(20));
        tree.getRightNode().setLeftNode(new TreeNode(15));
        tree.getRightNode().setRightNode(new TreeNode(7));
        rightSideOFTree(tree);
        System.out.println(result);
    }


}
