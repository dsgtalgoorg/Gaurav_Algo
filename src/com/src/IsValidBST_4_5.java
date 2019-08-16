import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class IsValidBST_4_5 {
    // Naive solution would be to create an ArrayList of the in-order traversal
    // of the tree and checking if the array is sorted in ascending order

    public boolean isValidBst(TreeNode root) {
        if (root == null) return true;
        return isValidBstRecurser(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBstRecurser(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val > min && root.val < max)
            return (
                isValidBstRecurser(root.left, min, root.val) &&
                isValidBstRecurser(root.right, root.val, max)
            );
        else return false;
    }

    /*
        TESTS
     */



    @Test
    public void emptyTree() {
        Integer[] arr = { null };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        assertTrue(isValidBst(root));
    }



    @Test
    public void singleton() {
        Integer[] arr = { null, 1 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        assertTrue(isValidBst(root));
    }

    @Test
    public void notBalanced1() {
        /*
             1
            /
           1

        */

        Integer[] arr = { null, 1, 1 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);
        System.out.println(root);

        assertFalse(isValidBst(root));
    }

    @Test
    public void notBalanced2() {
        /*
                10
            /       \
           2         51
          / \
         0   8
            /
           1


         */

        Integer[] arr = { null, 10, 2, 51, 0, 8, null, null, null, null, 1 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        assertFalse(isValidBst(root));
    }


    @Test
    public void balanced1() {
        /*
                10
            /       \
           2         51
          / \
         0   8
            /
           4


         */

        Integer[] arr = { null, 10, 2, 51, 0, 8, null, null, null, null, 4 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        assertTrue(isValidBst(root));
    }

    /*
        HELPER METHODS
     */

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(IsValidBST_4_5.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
