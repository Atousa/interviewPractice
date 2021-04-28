public class BuildTreeFromSortedArray {
//Tc = O(n) , SC= o(logn)+ 0(n)
    public static TreeNode buildTreeFromSortedArray(int[] arr) {
        return helper(arr, 0, arr.length-1);
    }

    private static TreeNode helper(int[] arr, int start, int end) {
        if(start > end) return null;

        if(start == end) {
            TreeNode newNode = new TreeNode(arr[start]);
            return newNode;
        }

        int mid = start + (end-start)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.setLeftNode(helper(arr,start, mid-1));
        n.setRightNode(helper(arr,mid+1,end));
        return n;
    }

}
