import java.util.NoSuchElementException;
import java.util.Stack;

public class PreOrderTraversal {

    static class treeNode {
        private int data;
        private treeNode leftNode;
        private treeNode rightNode;

        public treeNode(int data) {
            this.data = data;
        }
    }

    public static void preOrderTraversalRec(treeNode root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrderTraversalRec(root.leftNode);
        preOrderTraversalRec(root.rightNode);
    }

    public static void preOrderTraversal(treeNode root) {
        Stack<treeNode> s = new Stack<>();
        down(s, root);
        while (!s.isEmpty()) {
            treeNode temp = s.pop();
            if (temp.rightNode != null)
                down(s, temp.rightNode);
        }
    }


    private static void  down(Stack<treeNode> s, treeNode t) {
        if (t == null) throw new NoSuchElementException();
        while (t != null) {
            System.out.println(t.data);
            s.push(t);
            t = t.leftNode;
        }
    }

    public static void main(String[] args) {
        treeNode tree = new PreOrderTraversal.treeNode(1);
        tree.leftNode = new PreOrderTraversal.treeNode(2);
        tree.rightNode = new PreOrderTraversal.treeNode(3);
        tree.leftNode.leftNode = new PreOrderTraversal.treeNode(4);
        tree.leftNode.rightNode = new PreOrderTraversal.treeNode(5);
        tree.rightNode.leftNode = new PreOrderTraversal.treeNode(7);
        tree.rightNode.rightNode = new PreOrderTraversal.treeNode(8);
        preOrderTraversalRec(tree);
        preOrderTraversal(tree);

    }
}








