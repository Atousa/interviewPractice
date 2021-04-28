import com.sun.source.tree.Tree;

public class LCA {

    //compute LCA(lowest common ancestor) recursively
    public  static TreeNode lcaRec(TreeNode root, int d1, int d2) { //assume two nodes are exist
        if (root == null) return null;


        TreeNode leftNode = lcaRec(root.getLeftNode(), d1, d2);

        TreeNode rightNode = lcaRec(root.getRightNode(), d1, d2);

        if(leftNode!= null && rightNode!= null) return root;
        if(leftNode== null && rightNode == null) return null;

        return leftNode != null ? leftNode : rightNode;
    }


 // compute LCA when there is a parent node iteratively
    public static TreeNode lcaIterative(TreeNode d1, TreeNode d2) {
        int depth1 = getDepth(d1);
        int depth2 = getDepth(d2);
        int counter = 0;

        int diff = Math.abs(depth1 - depth2);

        if (depth1 > depth2) {
            while (diff-- > 0)
                d1 = d1.getParentNode();

        } else if (depth2 > depth1) {
            while (diff-- >= 0)
                d2 = d2.getParentNode();
        }

        while(d1.getData() != d2.getData()) {
            d1 = d1.getParentNode();
            d2 = d2.getParentNode();
        }
        return d1;
    }


    private static int getDepth(TreeNode node) {
        int depth = 0;
        while(node.getParentNode()!=null) {
            node = node.getParentNode();
            depth+=1;
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        t.setLeftNode(left);
        TreeNode right = new TreeNode(3);
        t.setRightNode(right);
        left.setParentNode(t);
        right.setParentNode(t);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        left.setRightNode(right2);
        left.setLeftNode(left2);
        left2.setParentNode(left);
        right2.setParentNode(left);
        TreeNode left3 = new TreeNode(6);
        TreeNode right3 = new TreeNode(7);
        right.setLeftNode(right3);
        right.setRightNode(left3);
        left3.setParentNode(right);
        right3.setParentNode(right);
        TreeNode tree = lcaRec(t, 2, 4);
        System.out.println(tree.getData());
        tree = lcaIterative(t.getLeftNode().getLeftNode(),t.getLeftNode());
        System.out.println(tree.getData());
    }


}
