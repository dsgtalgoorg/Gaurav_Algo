import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static junit.framework.TestCase.assertEquals;

@SuppressWarnings("Duplicates")
public class InOrderSuccessorSolution_4_6 {
    public Integer inOrderSuccessor(TreeNode node) {
        if (node == null) return null;
        if (node.right != null) {
            return returnLeftMost(node.right).val;
        } else {
            TreeNode current = node;
            TreeNode parent = current.parent;

            while (parent != null && parent.val < current.val) {
                current = parent;
                parent = parent.parent;
            }

            if (parent == null) return null;
            else return parent.val;
        }
    }

    private TreeNode returnLeftMost(TreeNode node) {
        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /*
        TESTS
     */


    @Test
    public void emptyTree() {
        Integer[] arr = { null };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        assertEquals(null, inOrderSuccessor(root));
    }



    @Test
    public void singleton() {
        Integer[] arr = { null, 1 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        assertEquals(null, inOrderSuccessor(root));
    }

    @Test
    public void happyPath1() {
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

        TreeNode tgt = TreeUtility.getNode(root, 0);

        Integer expected = 2;
        assertEquals(expected, inOrderSuccessor(tgt));
    }

    @Test
    public void happyPath2() {
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

        TreeNode tgt = TreeUtility.getNode(root, 2);

        Integer expected = 4;
        assertEquals(expected, inOrderSuccessor(tgt));
    }

    @Test
    public void happyPath3() {
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

        TreeNode tgt = TreeUtility.getNode(root, 8);

        Integer expected = 10;
        assertEquals(expected, inOrderSuccessor(tgt));
    }

    @Test
    public void happyPath4() {
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

        TreeNode tgt = TreeUtility.getNode(root, 4);

        Integer expected = 8;
        assertEquals(expected, inOrderSuccessor(tgt));
    }

    @Test
    public void happyPath5() {
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

        TreeNode tgt = TreeUtility.getNode(root, 10);

        Integer expected = 51;
        assertEquals(expected, inOrderSuccessor(tgt));
    }

    @Test
    public void happyPath6() {
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

        TreeNode tgt = TreeUtility.getNode(root, 51);

        Integer expected = null;
        assertEquals(expected, inOrderSuccessor(tgt));
    }

    /*
        HELPER METHODS
     */

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(InOrderSuccessorSolution_4_6.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
