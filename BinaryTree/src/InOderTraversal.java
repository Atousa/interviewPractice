

import java.util.NoSuchElementException;
import java.util.Stack;

public class InOderTraversal {

    static class treeNode {  //why static ? again why all the methods here should be static ?
        private int data;
        private treeNode leftNode;
        private treeNode rightNode;

        public treeNode(int data) {
            this.data = data;
        }
    }

    public static void inOrderTraversalRec(treeNode root) {
        if (root == null) return;
        inOrderTraversalRec(root.leftNode);
        System.out.println(root.data);
        inOrderTraversalRec(root.rightNode);
    }

    public static void inOrderTraversal(treeNode root) { // (time and space complexity is the number of nodes)?
        Stack<treeNode> s = new Stack<>();
        //InOderTraversal obj = new InOderTraversal();
        //obj.down(s, root);
        down(s, root);
        while (!s.isEmpty()) {
            treeNode temp = s.pop();
            System.out.println(temp.data);
            if (temp.rightNode != null)
                down(s, temp.rightNode);
        }
    }

    private static void down(Stack<treeNode> s, treeNode t) {
        if (t == null) throw new NoSuchElementException();
        while (t != null) {
            s.push(t);
            t = t.leftNode;
        }
    }

    public static void main(String[] args) {
        treeNode tree = new treeNode(1);
        tree.leftNode = new treeNode(2);
        tree.rightNode = new treeNode(3);
        tree.leftNode.leftNode = new treeNode(4);
        tree.leftNode.rightNode = new treeNode(5);
        tree.rightNode.leftNode = new treeNode(7);
        tree.rightNode.rightNode = new treeNode(8);
        inOrderTraversalRec(tree);
        inOrderTraversal(tree);



    }
}




