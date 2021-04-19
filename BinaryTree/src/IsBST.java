public class IsBST {

    public static boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBSTHelper(TreeNode root , int min, int max) {
        if(root==null) return true;
        if(root.getData() < min && root.getData() > max) return false;
        return isBSTHelper(root.getLeftNode(), min, root.getData()) && isBSTHelper(root.getRightNode(), root.getData(), max);

    }
}
