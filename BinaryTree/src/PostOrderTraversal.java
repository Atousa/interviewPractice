import java.util.NoSuchElementException;
import java.util.Stack;

public class PostOrderTraversal {
//post order traversal
        static class treeNode {
            private int data;
            private treeNode leftNode;
            private treeNode rightNode;

            public treeNode(int data) {
                this.data = data;
            }
        }

    public static void postOrderTraversalRec(treeNode root) {
        if (root == null) return;
        postOrderTraversalRec(root.leftNode);
        postOrderTraversalRec(root.rightNode);
        System.out.println(root.data);
    }

    public static void postOrderTraversal(treeNode root) {

        Stack<treeNode> s = new Stack<>();
        down(s, root);
        treeNode temp;
        while (!s.isEmpty()) {
            temp = s.peek();
            if (temp.rightNode != null)
                down(s, temp.rightNode);
            else {
                temp = s.pop();
                System.out.println(temp.data);

                while(!s.empty() && temp == s.peek().rightNode){
                    temp = s.pop();
                    System.out.println(temp.data);
                }
            }
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
        treeNode tree = new  treeNode(1);
        tree.leftNode = new treeNode(2);
        tree.rightNode = new treeNode(3);
        tree.leftNode.leftNode = new treeNode(4);
        tree.leftNode.rightNode = new treeNode(5);
        tree.rightNode.leftNode = new treeNode(7);
        tree.rightNode.rightNode = new treeNode(8);
        tree.rightNode.rightNode.rightNode = new treeNode(10);
        //postOrderTraversalRec(tree);
        postOrderTraversal(tree);
    }

}
