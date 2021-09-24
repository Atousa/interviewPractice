
    /*
        private static class TreeNode{
            public int val;
            public TreeNode left_ptr;
            public TreeNode right_ptr;
        }
    */
    
    /*
        Complete the function below
    */
    static TreeNode flipUpsideDown(TreeNode root){
        if(root == null) return root;
      
        if(root.left_ptr == null && root.right_ptr == null) {
            return root;
        }
        
        TreeNode newRoot =  flipUpsideDown(root.left_ptr);
        
        TreeNode temp = root.left_ptr;
        root.left_ptr = null;
        temp.left_ptr = root.right_ptr;
        temp.right_ptr = root;
        root.right_ptr = null;
        
        return newRoot;
    
    }

