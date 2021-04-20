import java.util.ArrayList;
import java.util.List;

// (nlogn) is space and time complexity, n path and the data doesnt grow more than log n

public class PathSum {
//TC= o(n)

    public static boolean pathSum(TreeNode root, int targetSum) {

        if(root == null) return false;
        if(root.getLeftNode() == null && root.getRightNode() == null && root.getData() == targetSum) return true;

        return pathSum(root.getLeftNode(), targetSum - root.getData()) || pathSum(root.getRightNode(),
                targetSum - root.getData());

    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.setLeftNode(new TreeNode(2));
        System.out.println(pathSum(tree, 1));
    }

}






