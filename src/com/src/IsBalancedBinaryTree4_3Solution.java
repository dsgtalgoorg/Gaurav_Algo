import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@SuppressWarnings("Duplicates")
public class IsBalancedBinaryTree4_3Solution {
//    public boolean isBalanced(TreeNode root) {
//        if (root != null) {
//            if (!isBalancedPostOrderRecurser(root, 0, 0)) return false;
//
//            isBalancedPostOrderRecurser(root, 0, 0);
//
//        }
//
//        return true;
//    }
//
//
//    private int isBalancedPostOrderRecurser(TreeNode node, int heightLeftSubTree, int heightRightSubTree) {
//
//        if (node.left == null) {
//            heightLeftSubTree = 0;
//        } else {
//            heightLeftSubTree++;
//        }
//
//        if (node.right == null) {
//            heightRightSubTree = 0;
//        } else {
//            heightRightSubTree++;
//        }
//
//        System.out.println(node.val);
//
//        if (node.left != null) {
//            System.out.println( " node.left  " + node.left.val );
//            isBalancedPostOrderRecurser(node.left , heightLeftSubTree, heightRightSubTree);
//        }
//        if (node.right != null) {
//            System.out.println( " node.right  " + node.right.val );
//            isBalancedPostOrderRecurser(node.right, heightLeftSubTree, heightRightSubTree); }
//
//
//        //System.out.println(node.val + "  " + heightLeftSubTree + " " + heightRightSubTree);
//        return node.val;
//    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return getHeight(root) != Integer.MIN_VALUE;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return -1;
        int heightLeftSubTree = getHeight(root.left);
        if (heightLeftSubTree == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int heightRightSubTree = getHeight(root.right);
        if (heightRightSubTree == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(heightLeftSubTree - heightRightSubTree) > 1) return Integer.MIN_VALUE;
        else return Math.max(heightLeftSubTree, heightRightSubTree) + 1;
    }


    /*
        TESTS
     */



    @Test
    public void emptyTree() {
        Integer[] arr = { null };
        TreeNode root = buildBinaryTree(arr);

        boolean result = isBalanced(root);
        assertTrue(result);
    }



    @Test
    public void singleton() {
        Integer[] arr = { null, 1 };
        TreeNode root = buildBinaryTree(arr);

        boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void notBalanced() {
        /*
                1
            /       \
           2         2
          / \
         3   3
        / \
       4   4

         */

        Integer[] arr = { null, 1, 2, 5, 3, 3, null, null, 4, 4 };
        TreeNode root = buildBinaryTree(arr);
        System.out.println(root);

        boolean result = isBalanced(root);
        assertFalse(result);
    }


    @Test
    public void balanced() {
        /*
                1
            /       \
           2         2
          / \       / \
         3   3     5   6
        / \
       4   4

         */

        Integer[] arr = { null, 1, 2, 5, 3, 3, 5, 6, 4, 4 };
        TreeNode root = buildBinaryTree(arr);
        System.out.println(root);

        boolean result = isBalanced(root);
        assertTrue(result);
    }



    /*
        HELPER METHODS
     */

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(IsBalancedBinaryTree4_3Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }



    private TreeNode buildBinaryTree(Integer[] input) {
        TreeNode root = null;
        if (input.length > 1) {
            root = new TreeNode(input[1]);
            buildBinaryTreeRecurser(root, 1, input);
        }
        return root;
    }

    private void buildBinaryTreeRecurser(TreeNode node, int index, Integer[] input) {
        int leftIndex = index * 2;
        int rightIndex = leftIndex + 1;
        TreeNode left = null;
        TreeNode right = null;
        if (node != null) {
            if (leftIndex < input.length) {
                if (input[leftIndex] != null) {
                    left = new TreeNode(input[leftIndex]);
                    node.left = left;
                }
                buildBinaryTreeRecurser(left, leftIndex, input);
            }
            if (rightIndex < input.length) {
                if (input[rightIndex] != null) {
                    right = new TreeNode(input[rightIndex]);
                    node.right = right;
                }
                buildBinaryTreeRecurser(right, rightIndex, input);
            }
        }
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
