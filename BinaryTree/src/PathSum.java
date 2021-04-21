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

    public static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<Integer> slate = new ArrayList<>();
        pathSumHelper(root,targetSum, slate);
        return result;
    }
    private static void pathSumHelper(TreeNode root, int targetSum, List<Integer> slate) {

        if(root.getLeftNode() == null && root.getRightNode() == null && root.getData() == targetSum) {
            slate.add(root.getData());
            List<Integer> l = new ArrayList<>(slate);
            result.add(l);
            slate.remove(slate.size()-1);
            return;
        }

        slate.add(root.getData());
        if(root.getLeftNode()!= null) {
            pathSumHelper(root.getLeftNode(), targetSum - root.getData(), slate);
        }
        if(root.getRightNode()!= null) {
            pathSumHelper(root.getRightNode(), targetSum - root.getData(), slate);
        }
        slate.remove(slate.size()-1);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.setLeftNode(new TreeNode(4));
        tree.setRightNode(new TreeNode(8));
        tree.getLeftNode().setLeftNode(new TreeNode(11));
        tree.getLeftNode().getLeftNode().setLeftNode(new TreeNode(7));
        tree.getLeftNode().getLeftNode().setRightNode(new TreeNode(2));
        tree.getRightNode().setLeftNode(new TreeNode(13));
        tree.getRightNode().setRightNode(new TreeNode(4));
        tree.getRightNode().getRightNode().setLeftNode(new TreeNode(5));
        tree.getRightNode().getRightNode().setRightNode(new TreeNode(1));
        //System.out.println(pathSum(tree, 1));
        pathSum2(tree,22);
        System.out.println(result);
    }

}






