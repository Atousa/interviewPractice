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
}



