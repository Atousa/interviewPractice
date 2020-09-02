public class Height {
    public static int height(TreeNode tree) {
        if(tree == null) return 0;
        if(tree == null) return 0;
        return Math.max(height(tree.getLeftNode()),height(tree.getRightNode())+1);
    }

}
