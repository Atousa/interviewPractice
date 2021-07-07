public class MaxDepthNaryTree {
    //559
    //Input: root = [1,null,3,2,4,null,5,6]
    //
    //Output: 3

    public int maxDepth(Node root) {
            if(root==null)  return 0;
            int max=0;
            for(Node child:root.children)
                max=Math.max(max,maxDepth(child));
            return max+1;
        }
    }
}
