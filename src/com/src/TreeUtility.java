public class TreeUtility {
    public static TreeNode buildBinaryTree(Integer[] input) {
        TreeNode root = null;
        if (input.length > 1) {
            root = new TreeNode(input[1]);
            root.parent = null;
            buildBinaryTreeRecurser(root, 1, input);
        }
        return root;
    }

    private static void buildBinaryTreeRecurser(TreeNode node, int index, Integer[] input) {
        int leftIndex = index * 2;
        int rightIndex = leftIndex + 1;
        TreeNode left = null;
        TreeNode right = null;
        if (node != null) {
            if (leftIndex < input.length) {
                if (input[leftIndex] != null) {
                    left = new TreeNode(input[leftIndex]);
                    left.parent = node;
                    node.left = left;
                }
                buildBinaryTreeRecurser(left, leftIndex, input);
            }
            if (rightIndex < input.length) {
                if (input[rightIndex] != null) {
                    right = new TreeNode(input[rightIndex]);
                    right.parent = node;
                    node.right = right;
                }
                buildBinaryTreeRecurser(right, rightIndex, input);
            }
        }
    }
}
