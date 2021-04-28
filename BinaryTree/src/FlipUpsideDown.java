public class FlipUpsideDown {
    //TC = 0(n) SC = 0(1)
    static TreeNode flipUpsideDown(TreeNode root){

        if (root==null || root.getLeftNode()==null) {
            return root;
        }

        TreeNode prev = null;
        TreeNode cur = root;
        TreeNode next = null;
        TreeNode lastRight = null;

        while (cur!=null) {
            next = cur.getLeftNode();

            cur.setLeftNode(lastRight);
            lastRight = cur.getRightNode();

            cur.setRightNode(prev);

            prev = cur;
            cur = next;
        }

        return prev;
    }

}
