// if a tree is a complete tree
public class IsPerfect {

    static class LeafLevel {
        int l;

        public int getL() {
            return l;
        }

        public void setL(int l) {
            this.l = l;
        }
    }

    public static boolean isPerfect(TreeNode root) {
        LeafLevel leaf = new LeafLevel();
        leaf.setL(-1);
        int curLevel = 0;
        return isPerfectHelper(root, leaf, curLevel);
    }


    private static boolean isPerfectHelper(TreeNode root, LeafLevel leaf, int curLevel) {

        if (root == null) return true;
        if ((root.getLeftNode() == null && root.getRightNode() != null) || (root.getRightNode() == null && root.getLeftNode() == null)) return false;
        if(root.getLeftNode() == null && root.getRightNode() == null){
            if (leaf.getL() == -1)
                leaf.setL(curLevel);
            else if (curLevel == leaf.getL())
                return true;
            else
                return false;
        }
        return isPerfectHelper(root.getLeftNode(), leaf, curLevel + 1) && isPerfectHelper(root.getRightNode(), leaf, curLevel + 1);
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
        TreeNode left4 = new TreeNode(9);
        right.getLeftNode().setLeftNode(left4);
        boolean b = isPerfect(t);
        System.out.println(b);

    }

}


