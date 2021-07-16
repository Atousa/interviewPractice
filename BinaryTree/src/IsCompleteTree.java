import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        boolean flag = false;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp.left != null) {
                if (flag) return false;
                queue.add(temp.left);
            } else flag = true;
            if (temp.right != null) {
                if (flag) return false;
                queue.add(temp.right);
            } else flag = true;
        }
        return true;
    }
}






