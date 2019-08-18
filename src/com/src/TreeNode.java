public class TreeNode {
    Integer value;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer value) {
        this.value = value;
    }

    public TreeNode() {
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static void printAll(TreeNode root) {
        System.out.println("=================================================");
        if (root == null) return;
        System.out.println("Root Node " + root.value);
        if (root.left != null)
            System.out.println("Left Node " + root.left.value);
        if (root.right != null)
            System.out.println("Right Node " + root.right.value);
        System.out.println("=================================================");
        printAll(root.left);
        printAll(root.right);
    }
}
