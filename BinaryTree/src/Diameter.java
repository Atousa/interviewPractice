
    /*
        private static class TreeNode{
            public int label;
            public TreeNode left_ptr;
            public TreeNode right_ptr;
        }

        Complete the function below.
    */
    static class Diameter{
        int height;
        int diam;
        public Diameter(int h, int d) {
            this.height = h;
            this.diam = d;
        }
    };


    static Integer binary_tree_diameter(TreeNode root) {
        
        Diameter dim = binary_tree_diameter_helper(root);
        return dim.diam;

    }
    
    static Diameter binary_tree_diameter_helper(TreeNode root) {
        if(root == null) {
            return (new Diameter(0,0));
        }
        
        Diameter left = binary_tree_diameter_helper(root.left_ptr);
        Diameter right = binary_tree_diameter_helper(root.right_ptr);
        
        int max = (left.height + right.height);
        if(max < left.diam){
            max = left.diam;
        }
        if(max < right.diam){
            max = right.diam;
        }
        return (new Diameter(Integer.max(left.height,right.height)+1, max));
    }
        
     
