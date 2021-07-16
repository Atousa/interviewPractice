
import java.util.LinkedList;
import java.util.Queue;

class Node {
     int val;
     Node left;
     Node right;
     Node() {}
     Node(int val) { this.val = val; }
     Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class NodeMap
{
    Node node;
    int index;

    public NodeMap(Node node, int index)
    {
        this.node = node;
        this.index = index;
    }
}



public class MaximumWidth {



    public static int maximumWidth(Node tree) {

        Queue<NodeMap> q = new LinkedList<>();
        q.offer(new NodeMap(tree, 0));
        int max = 1;

        while (!q.isEmpty()) {
            int s = q.size();
            int minIndex = Integer.MAX_VALUE;
            int maxIndex = Integer.MIN_VALUE;

            while (s > 0) {
                NodeMap n = q.poll();
                s--;
                if (n.node != null) {
                    minIndex = Math.min(minIndex, n.index);
                    maxIndex = Math.max(maxIndex, n.index);

                    NodeMap leftChild = new NodeMap(n.node.left, 2 * n.index + 1);
                    q.add(leftChild);
                    NodeMap rightChild = new NodeMap(n.node.right, 2 * n.index + 2);
                    q.add(rightChild);
                    max = Math.max(max, maxIndex - minIndex + 1);
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        root.left.left = new Node(5);
        root.left.left.left = new Node(6);


        root.right.right = new Node(9);
        root.right.right.right = new Node(7);

        int b = maximumWidth(root);
        System.out.println(b);

    }


}
