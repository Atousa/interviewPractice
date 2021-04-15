import java.util.*;


public class ZigzagTraversal {

    static List<List<Integer>> result = new ArrayList<>();

    public static void zigzagTraversal(TreeNode root) {

        if (root == null) throw new NullPointerException();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftFlag = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>(size);
            while (size > 0) {
                TreeNode temp = q.poll();
                size--;
                l.add(temp.getData());
                if (temp.getLeftNode() != null)
                    q.add(temp.getLeftNode());
                if (temp.getRightNode() != null)
                    q.add(temp.getRightNode());
            }
            if (leftFlag) {
                leftFlag = true;
            } else {
                Collections.reverse(l);
                leftFlag = false;
            }
            result.add(l);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.setLeftNode(new TreeNode(9));
        tree.setRightNode(new TreeNode(20));
        tree.getLeftNode().setLeftNode(new TreeNode(11));
        tree.getLeftNode().setRightNode(new TreeNode(10));
        tree.getRightNode().setLeftNode(new TreeNode(15));
        tree.getRightNode().setRightNode(new TreeNode(7));
        zigzagTraversal(tree);
        System.out.println(result);
    }


}
