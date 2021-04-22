import java.util.ArrayList;
import java.util.List;

public class AllPathOfBT {

    public static List<String> result = new ArrayList<>();

    public static List<String> allPathsOfABinaryTree(TreeNode root) {

        List<Integer> slate = new ArrayList<>();
        allPathsOfABinaryTreeHelper(root, slate);
        return result;
    }

    private static void allPathsOfABinaryTreeHelper(TreeNode root, List<Integer> slate) {

        if (root.getLeftNode() == null && root.getRightNode() == null) {
            slate.add(root.getData());
            StringBuilder sb = new StringBuilder();
            sb.append(slate.get(0));
            for(int i=1; i < slate.size(); i ++) {
                sb.append("->");
                sb.append(slate.get(i));
            }
            result.add(sb.toString());
            slate.remove(slate.size() - 1);
            return;
        }

        slate.add(root.getData());
        if(root.getLeftNode() != null)
            allPathsOfABinaryTreeHelper(root.getLeftNode(), slate);

        if(root.getRightNode() != null)
            allPathsOfABinaryTreeHelper(root.getRightNode(), slate);

        slate.remove(slate.size() - 1);
        return;

    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(100);
        tree.setLeftNode(new TreeNode(200));
        tree.setRightNode(new TreeNode(300));
        tree.getLeftNode().setRightNode(new TreeNode(500));
        allPathsOfABinaryTree(tree);
        System.out.println(result);
    }
}


