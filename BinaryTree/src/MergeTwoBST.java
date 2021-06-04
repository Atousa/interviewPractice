import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST {
//TC= o(m+n) SC=o(o(m+n)logn)
    public static TreeNode mergeTwoBSTs(TreeNode root1, TreeNode root2) {

        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();

        inOrderTraversal(root1, l1);
        inOrderTraversal(root2, l2);

        List<TreeNode> newList = merge(l1, l2);

        return constructTree(newList, 0, newList.size()-1);
    }

    private static void inOrderTraversal(TreeNode tree, List<TreeNode> l1) {
        if (tree == null) return;

        inOrderTraversal(tree.getLeftNode(), l1);
        l1.add(tree);
        inOrderTraversal(tree.getRightNode(), l1);
    }

    private static List<TreeNode> merge(List<TreeNode> l1, List<TreeNode> l2) {
        List<TreeNode> l3 = new ArrayList<>();
        int idx1 = l1.size();
        int idx2 = l2.size();
        int i = 0;
        int j = 0;

        while (i < idx1 && j < idx2) {
            if (l1.get(i).getData() <= l2.get(j).getData()) {
                l3.add(l1.get(i++));
            } else
                l3.add(l2.get(j++));
        }
        while (i < idx1)
            l3.add(l1.get(i++));
        while (j < idx2)
            l3.add(l2.get(j++));
        return l3;
    }

    private static TreeNode constructTree(List<TreeNode> l3, int start, int end) {

        if(start == end) {
            TreeNode h = new TreeNode((l3.get(start).getData()));
            return h;
        }

        if(start > end) return null;

        int mid = start + (end-start)/2;
        TreeNode m = new TreeNode((l3.get(mid).getData()));
        m.setLeftNode(constructTree(l3,start,mid-1));
        m.setRightNode(constructTree(l3,mid+1,end));
        return m;
    }
}


