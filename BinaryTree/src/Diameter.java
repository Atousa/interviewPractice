public class Diameter {

    //Write a function that returns the length of the longest leaf-to-leaf path in a binary tree
    static class D{
        int diameter = Integer.MIN_VALUE;
    }
    public static int diameter(TreeNode root) {
        if(root == null) return 0;
        D diam = new D();
        height(root, diam);
        return diam.diameter;
    }
    public static int height(TreeNode root,D d) {
        if(root==null) {
            d.diameter=0;
            return 0;
        }
        int leftHeight = height(root.getLeftNode(),d);
        int rightHeight = height(root.getRightNode(),d);

        d.diameter = Math.max(d.diameter,(leftHeight+rightHeight+1));

        return Math.max(rightHeight,leftHeight)+1;
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
        right.setLeftNode(new TreeNode((9)));
        System.out.println(diameter(t));
    }
}
