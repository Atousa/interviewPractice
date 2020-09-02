import java.util.ArrayDeque;
import java.util.Deque;

//iterative way to compute the height of the tree
public class LevelTraversal { //BFS use Queue data structure, was the time complexity is # nodes in the tree?


    static class treeNode {
        private int data;
        private treeNode leftNode;
        private treeNode rightNode;

        public treeNode(int data) {
            this.data = data;
        }
    }

    public static int levelTraversal(treeNode root) {
        if(root == null) throw new NullPointerException();
        Deque<treeNode> q = new ArrayDeque<>(); //what if I want to use Queue?
        q.push(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                treeNode temp = q.pop(); //from the first element (pop,push, peek like stack)
                size--;
                if (temp.leftNode != null) q.add(temp.leftNode);
                if (temp.rightNode != null) q.add(temp.rightNode);
                System.out.println(temp.data);;
            }
            level+=1;
        }
        return level;
    }

    public static void main(String[] args) {
            treeNode tree = new treeNode(1);
            tree.leftNode = new treeNode(2);
            tree.rightNode = new treeNode(3);
            tree.leftNode.leftNode = new treeNode(4);
            tree.leftNode.rightNode = new treeNode(5);
            tree.rightNode.leftNode = new treeNode(6);
            tree.rightNode.rightNode = new treeNode(7);
            int l = levelTraversal(tree);
        System.out.println(l);

        }

    }

