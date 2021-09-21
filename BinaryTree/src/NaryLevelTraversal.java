public class NaryLevelTraversal {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {

            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;

            Queue<Node> q = new LinkedList<>();
            q.offer(root);


            while(!q.isEmpty()) {
                int size = q.size();
                List<Integer> l = new ArrayList<>();
                while(size > 0) {
                    Node temp = q.poll();
                    size--;
                    l.add(temp.val);
                    for(Node n: temp.children)
                        q.offer(n);
                }
                result.add(l);

            }
            return result;

        }
    }
}
