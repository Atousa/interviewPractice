import com.sun.source.tree.Tree;

public class IsHalves {

    /**
    Check if removing an edge can divide a Binary Tree in two halves
     The complexity is o(n^2)
     */


    public static boolean isHalves(TreeNode root, int numNodes) {

        if(root==null) return true;

        int numLeftNodes = numNodes(root.getLeftNode());
        int numRightNodes = numNodes(root.getRightNode());

        isHalves(root.getLeftNode(), numNodes + 1 + numRightNodes);
        isHalves(root.getRightNode(), numNodes + 1 + numLeftNodes);

        if (numLeftNodes == numNodes + 1 + numRightNodes) return true;
        if (numRightNodes == numNodes + 1 + numLeftNodes) return true;
        return false;
    }

    private static int numNodes(TreeNode node){
        if(node==null)return 0;
        return 1 + numNodes(node.getLeftNode()) + numNodes(node.getRightNode());
    }


    /**
     Check if removing an edge can divide a Binary Tree in two halves
     The complexity is o(n)
     */


    /**
     * class to hold the state of the tree, if it's possible to berak it into two equal halves
     */

    static class  STATE{
        boolean b = false;
        public STATE(boolean f){
            this.b = f;
        }
    }


    public static boolean isHalvesSec(TreeNode root) {
        STATE s = new STATE(false);
        checkUtil(root,countNodes(root),s );
        return (s.b);
    }

    /**
     * This util method will try to check for the possible solution and set the state accordingly
     */

    private static int checkUtil(TreeNode root, int size,STATE s) {
        if (root == null)
            return 0;
        int totalNode = checkUtil(root.getLeftNode(), size, s) + checkUtil(root.getRightNode(), size, s);
        if (1 + totalNode == size - totalNode)
            s.b = true;
        return totalNode;
    }

    /**
     count number of nodes in a tree
     */
    private static int countNodes(TreeNode root){
        if(root == null) return 0;
        return 1 + countNodes(root.getLeftNode())+ countNodes(root.getRightNode());
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        t.setLeftNode(left);
        TreeNode right = new TreeNode(6);
        t.setRightNode(right);
        TreeNode left2 = new TreeNode(3);
        left.setLeftNode(left2);
        TreeNode left3 = new TreeNode(4);
        TreeNode right3 = new TreeNode(7);
        right.setLeftNode(right3);
        right.setRightNode(left3);
        right3.setLeftNode(new TreeNode(3));
        right3.setRightNode(new TreeNode(2));
        left3.setRightNode(new TreeNode(8));
        System.out.println(isHalvesSec(t));
    }
}

