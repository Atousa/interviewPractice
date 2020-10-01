public class IfSumTree {

    /**
     * if a tree is a sumTree
     */

    static class Result {
        public int sum;
        public boolean valid;
        public Result() {
            sum=0; valid=true;
        }
        public Result(int s, boolean v) {
            sum=s; valid=v;
        }
    }

    public static Result ifSumTree(TreeNode root) {
        if (root == null) {
            return new Result();
        }
        if(root.getRightNode() == null && root.getLeftNode()==null){
            return new Result(root.getData(),true);
        }
        Result left = ifSumTree(root.getLeftNode());
        Result right = ifSumTree(root.getRightNode());
        return new Result(root.getData()+left.sum+right.sum , left.valid && right.valid && root.getData() == left.sum + right.sum) ;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(26);
        TreeNode left = new TreeNode(10);
        t.setLeftNode(left);
        TreeNode right = new TreeNode(3);
        t.setRightNode(right);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(6);
        left.setLeftNode(left2);
        left.setRightNode(right2);
        TreeNode left3 = new TreeNode(3);
        right.setRightNode(left3);
        Result r = ifSumTree(t);
        System.out.println(r.valid);

    }
}


