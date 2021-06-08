import javax.swing.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ConstructBSTFromPreOrder {
    static int curIdx = 0;

    static TreeNode build_binary_search_tree(ArrayList<Integer> preorder) {
        return build_binary_search_tree_helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode build_binary_search_tree_helper(ArrayList<Integer> preorder, Integer min, Integer max) {

        if (curIdx == preorder.size()) return null;

        if (preorder.get(curIdx) > max || preorder.get(curIdx) < min)
            return null;


        TreeNode root = new TreeNode(preorder.get(curIdx));
        curIdx++;
        root.setLeftNode(build_binary_search_tree_helper(preorder, min, root.getData()));
        root.setRightNode(build_binary_search_tree_helper(preorder, root.getData(), max));
        return root;
    }
}



