public class KSmallestElement {

    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };
    */

    static int kth_smallest_element(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        inOrderTraversal(root,l);
        int ele = l.get(k-1);
        return ele;

    }
    static void inOrderTraversal(TreeNode root,List<Integer> l ) {
        if(root == null) return;
        inOrderTraversal(root.left_ptr,l);
        l.add(root.val);
        inOrderTraversal(root.right_ptr,l);
    }

}
