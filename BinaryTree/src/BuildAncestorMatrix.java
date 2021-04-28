public class BuildAncestorMatrix {

//build ancestorMatrix from a tree
    public static void buildAncestorMatrix(TreeNode root, int ancMatrix[][], int k) {

        if (root == null) {
            ancMatrix = new int[k][k];
            return;
        }

        buildAncestorMatrix(root.getLeftNode(), ancMatrix, k);
        buildAncestorMatrix(root.getRightNode(), ancMatrix, k);

        if (root.getLeftNode() != null) {
            ancMatrix[root.getData()][root.getLeftNode().getData()] = 1;

            for (int i = 1; i <= k; i++) {
                if (ancMatrix[root.getLeftNode().getData()][i] == 1) {
                    ancMatrix[root.getData()][i] = 1;
                }
            }
        }

        if (root.getRightNode() != null) {
            ancMatrix[root.getData()][root.getRightNode().getData()] = 1;

            for (int i = 1; i <= k; i++) {
                if (ancMatrix[root.getRightNode().getData()][i] == 1) {
                    ancMatrix[root.getData()][i] = 1;
                }
            }
        }
    }
}




