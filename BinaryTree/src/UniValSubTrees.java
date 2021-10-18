public class UniValSubTrees {
//leetcode 250
    public static int num = 0;

    public static int uniValSubTrees(TreeNode tree) {

        ifUniValSubTreesHelper(tree);
        return num;
    }

    private static boolean ifUniValSubTreesHelper(TreeNode tree) {

        if (tree.getLeftNode() == null && tree.getRightNode() == null) {
            num += 1;
            return true;
        }

        boolean leftVal = ifUniValSubTreesHelper(tree.getLeftNode());
        boolean rightVal = ifUniValSubTreesHelper(tree.getRightNode());

        if (leftVal && rightVal) {

            if (tree.getRightNode() == null && tree.getData() == tree.getLeftNode().getData()) {
                num += 1;
                return true;
            } else if (tree.getLeftNode() == null && tree.getData() == tree.getRightNode().getData()) {
                num += 1;
                return true;
            } else if (tree.getData() == tree.getLeftNode().getData() && tree.getData() == tree.getRightNode().getData()) {
                num += 1;
                return true;
            }
        }
        return false;
    }
private static boolean helper2(TreeNode root) {

        if (root == null) return true;

        // if (root.left == null && root.right == null) {
        //     num += 1;
        //     return true;
        // }
        boolean n1 = helper(root.left);
        boolean n2 = helper(root.right);
        

        if (n1 && n2) {
            if (root.left != null) {
                if (root.left.val != root.val) {
                    return false;
                }
            }
            if (root.right != null) {
                if (root.val != root.right.val) {
                    return false;
                }
            } 
            num++;
            return true;
                
        }
        return false;
    }
}



