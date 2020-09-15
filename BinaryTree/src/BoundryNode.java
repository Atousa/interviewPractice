import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoundryNode{

    public static void boundryNode(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        nodeList.add(root.getData());
        boundryNodeUtil(root, nodeList);
        for(Integer node: nodeList)
            System.out.println(node);
    }
    private static void boundryNodeUtil(TreeNode root, List<Integer> nodeList) {
        traverseLeft(root.getLeftNode(),nodeList);
        findLeaves(root,nodeList);
        traverseRight(root.getRightNode(),nodeList);
    }

    private static void traverseLeft(TreeNode r, List<Integer> nodeList) {
        if(r == null) return;
        if(r.getLeftNode() != null || r.getRightNode() != null) {
            nodeList.add(r.getData());
        }
        traverseLeft(r.getLeftNode(),nodeList);
        if(r.getLeftNode() == null)
            traverseLeft(r.getRightNode(),nodeList);
    }
    private static void traverseRight(TreeNode r, List<Integer> nodeList) {
            if(r == null) return;
            if(r.getLeftNode() != null || r.getRightNode() != null) {
                nodeList.add(r.getData());
            }
            traverseLeft(r.getRightNode(),nodeList);
            if(r.getRightNode() == null) {
                traverseRight(r.getLeftNode(),nodeList);
        }
    }

    private static void findLeaves(TreeNode r, List<Integer> nodeList)  {
        if(r==null) return;

        if(r.getRightNode()==null && r.getRightNode()==null) {
            nodeList.add(r.getData());
            return;
        }
        findLeaves(r.getLeftNode(),nodeList);
        findLeaves(r.getRightNode(),nodeList);
    }


        public static void main(String[] args) {
            TreeNode tree = new TreeNode(10);
            tree.setLeftNode(new TreeNode(8));
            tree.setRightNode(new TreeNode(2));
            TreeNode leftNode = tree.getLeftNode();
            leftNode.setLeftNode(new TreeNode(3));
            leftNode.setRightNode(new TreeNode(5));
            TreeNode rightNode = tree.getRightNode();
            rightNode.setRightNode(new TreeNode(12));
            boundryNode(tree);

    }

}
