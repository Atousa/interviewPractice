public class IsFull {
    //if it is a full tree

    public static boolean isFull(TreeNode root) {
        if(root == null) return true;
        if(root.getLeftNode() == null && root.getRightNode() == null) return true;
        if(root.getLeftNode() != null && root.getRightNode() !=null)
            return isFull(root.getLeftNode()) && isFull(root.getRightNode());
        return false;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        t.setLeftNode(left);
        TreeNode right = new TreeNode(2);
        t.setRightNode(right);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        left.setRightNode(right2);
        left.setLeftNode(left2);
        TreeNode left3 = new TreeNode(4);
        TreeNode right3 = new TreeNode(5);
        right.setLeftNode(right3);
        right.setRightNode(left3);
        boolean b = isFull(t);
        System.out.println(b);
    }

}
