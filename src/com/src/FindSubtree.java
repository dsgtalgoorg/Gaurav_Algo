

public class FindSubtree {
    public static void main(String[] args) {
        TreeNode t41 = new TreeNode(0);
        TreeNode t51 = new TreeNode(5);
        TreeNode t61 = new TreeNode(20);
        TreeNode t71 = new TreeNode(80);
        TreeNode t21 = new TreeNode(2, t41, t51);
        TreeNode t31 = new TreeNode(51, t61, t71);
        TreeNode bigTree = new TreeNode(10, t21, t31);
        TreeNode smallTree = new TreeNode(2, t41, t51);
        System.out.println(findSubTree(bigTree, smallTree));

    }

    private static boolean findSubTree(TreeNode bigTree, TreeNode smallTree) {
        if (bigTree == null) return false;
        if (bigTree.value == smallTree.value && validateSubtree(bigTree, smallTree)) return true;
        return findSubTree(bigTree.left, smallTree) || findSubTree(bigTree.right, smallTree);
    }

    private static boolean validateSubtree(TreeNode bigTree, TreeNode smallTree) {
        if (bigTree == null && smallTree == null) return true;
        else if (bigTree == null || smallTree == null) return false;
        else if (bigTree.value != smallTree.value) return false;
        else return validateSubtree(bigTree.left, smallTree.left) && validateSubtree(bigTree.right, smallTree.right);
    }

}
