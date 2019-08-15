public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(11);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(10, t2, t3);
        System.out.println(validateBinarySearchTree(t1, null, null));

        TreeNode t41 = new TreeNode(1);
        TreeNode t51 = new TreeNode(7);
        TreeNode t21 = new TreeNode(6, t41, t51);
        TreeNode t31 = new TreeNode(13);
        TreeNode t11 = new TreeNode(10, t21, t31);
        System.out.println(validateBinarySearchTree(t11, null, null));

    }

    private static boolean validateBinarySearchTree(TreeNode t1, Integer min, Integer max) {
        if (t1 == null) return true;
        if (min != null && t1.value <= min) {
            return false;
        }
        if (max != null && t1.value > max) {
            return false;
        }
        return validateBinarySearchTree(t1.left, min, t1.value) && validateBinarySearchTree(t1.right, t1.value, max);
    }
}
