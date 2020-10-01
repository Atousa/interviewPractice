public class IsCousin {

    public static boolean isCousin(TreeNode root, TreeNode x, TreeNode y) {
        return (level(root, 0, x) == level(root,0,y)) && (!IsSibling(root, x, y));
    }

    /**
     * This method returns the level of the treeNode node, in the tree with root as rootNode.
     * level value will start with 0
     *
     * If the root is null or node is not present in the tree, then return -1
     *
     */


    private static int level(TreeNode root, int level, TreeNode node) {
        if(root == null) return -1;
        if(root.getData() == node.getData()) return level;
        int l = level(root.getLeftNode(), level+1, node);
        return l!=-1 ? l :  level(root.getRightNode(), level+1, node);
    }
    /**
     * This method will say if the two nodes given are siblings are not
     */


    private static boolean IsSibling(TreeNode root, TreeNode a, TreeNode b) {
        if(root == null) return false;

        return (root.getLeftNode() == a && root.getRightNode() == b) || (root.getLeftNode() == b && root.getRightNode() == a) ||
                IsSibling(root.getLeftNode(),a,b) || IsSibling(root.getRightNode(),a,b);
    }

    //Driver program to test above functions

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.setLeftNode(new TreeNode(2));
        root.setRightNode(new TreeNode(3));

        root.getLeftNode().setLeftNode(new TreeNode(4));
        root.getLeftNode().setRightNode(new TreeNode(5));
        root.getLeftNode().getRightNode().setRightNode(new TreeNode(15));

        root.getRightNode().setLeftNode(new TreeNode(6));
        root.getRightNode().setRightNode(new TreeNode(7));

        root.getRightNode().getLeftNode().setRightNode(new TreeNode(8));

        TreeNode node1, node2;
        node1 = root.getLeftNode().getRightNode();
        node2 = root.getRightNode().getRightNode();

        System.out.println(isCousin(root, node1, node2));
    }
}




