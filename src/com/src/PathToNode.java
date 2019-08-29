import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

@SuppressWarnings("Duplicates")
public class PathToNode {
    public List<Integer> pathToNode(TreeNode root, int tgtVal) {
        List<Integer> list = new ArrayList<>();
        pathToNodeRecurser(root, tgtVal, list, false);
        return list.size() < 1 ? null : list;
    }

    private boolean pathToNodeRecurser(TreeNode node, int tgtVal, List<Integer> list, boolean found) {
        if (node == null) { // null root
            return false;
        }

        if (found) {
            return true;
        }

        list.add(node.val);

        if (node.val == tgtVal) {
            return true;
        }
        if (node.left != null) {
            found = pathToNodeRecurser(node.left, tgtVal, list, found);
        }
        if (node.right != null) {
            found = pathToNodeRecurser(node.right, tgtVal, list, found);
        }
        if (!found) {
            list.remove(list.size() -1);
        }
        return found;
    }

    /*
        TESTS
     */

    @Test
    public void emptyTree() {
        Integer[] arr = { null };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        assertNull(pathToNode(root, 1));
    }

    @Test
    public void singleton() {
        Integer[] arr = { null, 1 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int[] expected = {1};
        Assert.assertArrayEquals(expected, pathToNode(root, 1).stream().mapToInt(Integer::intValue).toArray());

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

        int[] expected = {10, 2, 0};
        Assert.assertArrayEquals(expected, pathToNode(root, 0).stream().mapToInt(Integer::intValue).toArray());
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

        int[] expected = {10, 2, 8, 4};
        Assert.assertArrayEquals(expected, pathToNode(root, 4).stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void happyPath3() {
        /*
                10
            /       \
           2         51
          / \       /  \
         0   8     40   5
            /     /  \
           4     3    7


         */

        Integer[] arr = { null, 10, 2, 51, 0, 8, 40, 5, null, null, 4, null, 3, 7};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int[] expected = {10, 51, 40, 7};
        Assert.assertArrayEquals(expected, pathToNode(root, 7).stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void happyPath4() {
        /*
                10
            /       \
           2         51
          / \       /  \
         0   8     40   5
            /     /  \
           4     3    7


         */

        Integer[] arr = { null, 10, 2, 51, 0, 8, 40, 5, null, null, 4, null, 3, 7};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int[] expected = {10, 51, 40, 3};
        Assert.assertArrayEquals(expected, pathToNode(root, 3).stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void happyPath5() {
        /*
                10
            /       \
           2         51
          / \       /  \
         0   8     40   5
            /     /  \
           4     3    7


         */

        Integer[] arr = { null, 10, 2, 51, 0, 8, 40, 5, null, null, 4, null, 3, 7};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int[] expected = {10, 51, 5};
        Assert.assertArrayEquals(expected, pathToNode(root, 5).stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void happyPath6() {
        /*
                10
            /       \
           2         51
          / \       /  \
         0   8     40   5
            /     /  \
           4     3    7


         */

        Integer[] arr = { null, 10, 2, 51, 0, 8, 40, 5, null, null, 4, null, 3, 7};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int[] expected = {10, 51, 40};
        Assert.assertArrayEquals(expected, pathToNode(root, 40).stream().mapToInt(Integer::intValue).toArray());
    }

    /*
        HELPER METHODS
     */

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PathToNode.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
