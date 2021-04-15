public class Diameter {
    public static int maxDiam = Integer.MIN_VALUE;

    public static int diameter(TreeNode root) {
        if(root == null)
            return 0;

        int leftDiam = diameter(root.getLeftNode());
        int rightDiam = diameter(root.getRightNode());

        int m =  leftDiam + rightDiam;
        if(m > maxDiam) maxDiam = m;
        return (Math.max(leftDiam,rightDiam) + 1);
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(8);
//        TreeNode t9 = new TreeNode(9);
//        TreeNode t10 = new TreeNode(10);
//        TreeNode t11 = new TreeNode(11);
        t0.setLeftNode(t1);
//        t0.setRightNode(t2);
//        t1.setLeftNode(t3);
//        t1.setRightNode(t4);
//        t2.setRightNode(t5);
//        t4.setLeftNode(t6);
//        t4.setRightNode(t7);
//        t5.setRightNode(t8);
//        t8.setLeftNode(t9);
//        t8.setRightNode(t10);
//        t9.setRightNode(t11);
        diameter(t0);
        System.out.println(maxDiam);
    }

}
