public class Diameter {
        //Write a function that returns the length of the longest leaf-to-leaf path in a binary tree
        static class Diam{
            private int diameter;
            private int height;

            public Diam(int d, int h) {
                this.diameter = d;
                this.height = h;
            }

            public int getDiameter() {
                return diameter;
            }

            public void setDiameter(int diameter) {
                this.diameter = diameter;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

        }

    public static Diam diameter(TreeNode root) {
        if(root == null) return new Diam(0,0);

        Diam leftDiam = diameter(root.getLeftNode());
        Diam rightDiam = diameter(root.getRightNode());
        int height = Integer.max(leftDiam.height,rightDiam.height)+1;
        int diameter = Integer.max(Integer.max(leftDiam.diameter, rightDiam.diameter), leftDiam.height+rightDiam.height+1);
        Diam diam = new Diam(diameter , height );
        return diam;
    }

    public static void main(String[] args) {


        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        t0.setLeftNode(t1);
        t0.setRightNode(t2);
        t1.setLeftNode(t3);
        t1.setRightNode(t4);
        t2.setRightNode(t5);
        t4.setLeftNode(t6);
        t4.setRightNode(t7);
        t5.setRightNode(t8);
        t8.setLeftNode(t9);
        t8.setRightNode(t10);
        t9.setRightNode(t11);
        System.out.println(diameter_JLD(t0).diameter);
    }
}
