public class IsBalanced {

    public static class HeightBalanced {
        boolean balanced;
        int height;

        public HeightBalanced(int h, boolean b) {
            this.balanced = b;
            this.height = h;
        }
    }


    public static boolean isBalanced(TreeNode root) {
        HeightBalanced f = isBalancedHelper(root);
        return (f.balanced);
    }

    public static HeightBalanced isBalancedHelper(TreeNode root) {
        if(root == null) return (new HeightBalanced(0,true));

        HeightBalanced leftSubtree = isBalancedHelper(root.getLeftNode());
        HeightBalanced rightSubtree = isBalancedHelper(root.getRightNode());

        if((!leftSubtree.balanced) || (!rightSubtree.balanced) || (Math.abs(leftSubtree.height - rightSubtree.height) > 1))
            return (new HeightBalanced(Math.max(leftSubtree.height,rightSubtree.height )+1,false));

        return (new HeightBalanced(Math.max(leftSubtree.height,rightSubtree.height )+1, true));
    }
    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.setRightNode(new TreeNode(3));
        root.getRightNode().setRightNode(new TreeNode(4));
        root.getRightNode().getRightNode().setRightNode(new TreeNode(5));
        root.getRightNode().getRightNode().getRightNode().setRightNode(new TreeNode(6));
        boolean b =  isBalanced(root);
        System.out.println(b);

    }
}





