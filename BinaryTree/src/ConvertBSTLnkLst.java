public class ConvertBSTLnkLst {

    static public TreeNode head = null;
    static public TreeNode previous = null;

    static TreeNode binary_tree_to_cdll(TreeNode root){
        if(root == null) return root;
        binary_tree_to_cdll_helper(root);
        head.left_ptr = previous;
        previous.right_ptr = head;
        return head;
    }

    static void binary_tree_to_cdll_helper(TreeNode cur) {
        if(cur == null) return;

        binary_tree_to_cdll_helper(cur.left_ptr);
        if(previous == null) {
            head = cur;
        } else {
            previous.right_ptr = cur;
            cur.left_ptr = previous;

        }
        previous = cur;
        binary_tree_to_cdll_helper(cur.right_ptr);

    }

}
