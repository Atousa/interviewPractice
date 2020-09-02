public class HeightBalanced {
    public boolean balanced;
    public int height;

    public HeightBalanced(int h, boolean b) {
        this.balanced = b;
        this.height = h;
    }

    public static HeightBalanced heightBalanced(TreeNode tree) {

        if (tree == null) return new HeightBalanced(0, true);

        HeightBalanced leftResult = heightBalanced(tree.getLeftNode());
        if (!leftResult.balanced) {
            leftResult.height += 1; //this program doesn't show the right height if the tree is not height balanced
            return leftResult;
        }

        HeightBalanced rightResult = heightBalanced(tree.getRightNode());
        if (!rightResult.balanced) {
            rightResult.height += 1; //this program doesn't show the right height if the tree is not height balanced
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <=1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new HeightBalanced(height, isBalanced);

    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        t.setLeftNode(left);
        TreeNode right = new TreeNode(3);
        t.setRightNode(right);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        left.setRightNode(right2);
        left.setLeftNode(left2);
        TreeNode left3 = new TreeNode(7);
        left2.setLeftNode(left3);
        HeightBalanced hb;
        hb = heightBalanced(t);
        System.out.println(hb.balanced);
        System.out.println(hb.height);

    }




}
