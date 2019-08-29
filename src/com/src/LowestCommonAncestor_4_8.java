import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("Duplicates")
public class LowestCommonAncestor_4_8 {
    public TreeNode lca(TreeNode root, int val1, int val2) {
        return null;
    }

    public int lcaBrute(TreeNode root, int val1, int val2) {
        List<Integer> pathTo1 = PathToNode.pathToNode(root, val1);
        List<Integer> pathTo2 = PathToNode.pathToNode(root, val2);

        int current = pathTo1.get(0);

        for (int i = 0; i < pathTo1.size() - 1; i++) {

            if (pathTo1.get(i) != pathTo2.get(i)) {
                current = pathTo1.get(i - 1);
                break;
            }
        }
        return current;
    }


    /*
        TESTS
     */

    @Test
    public void emptyTree() {
        Integer[] arr = { null };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

//        assertNull(lca(root, 1));
    }

    @Test
    public void singleton() {
        Integer[] arr = { null, 1 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int[] expected = {1};
//        assertArrayEquals(expected, lca(root, 1).stream().mapToInt(Integer::intValue).toArray());

    }

    @Test
    public void happyPath1() {
/*
                1
            /       \
           2         3
          / \       / \
         4   5     6   7
        /\   /\   /\   /\
       8  9 10 n 11 12 n n
      / \
     13 14

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, 11, 12, null, null, 13, 14};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 2;
//        assertEquals(expected, lca(root, 10, 13));
        assertEquals(expected, lcaBrute(root, 10, 13));
    }

    @Test
    public void happyPath2() {
 /*
                1
            /       \
           2         3
          / \       / \
         4   5     6   7
        /\   /\   /\   /\
       8  9 10 n 11 12 n n
      / \
     13 14

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, 11, 12, null, null, 13, 14};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 1;
//        assertEquals(expected, lca(root, 10, 13));
        assertEquals(expected, lcaBrute(root, 9, 11));
    }

    @Test
    public void happyPath3() {
  /*
                1
            /       \
           2         3
          / \       / \
         4   5     6   7
        /\   /\   /\   /\
       8  9 10 n 11 12 n n
      / \
     13 14

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, 11, 12, null, null, 13, 14};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 3;
//        assertEquals(expected, lca(root, 10, 13));
        assertEquals(expected, lcaBrute(root, 12, 7));
    }

    @Test
    public void happyPath4() {
/*
                1
            /       \
           2         3
          / \       / \
         4   5     6   7
        /\   /\   /\   /\
       8  9 10 n 11 12 n n
      / \
     13 14

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, 11, 12, null, null, 13, 14};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 2;
        assertEquals(expected, lca(root, 10, 13));
    }

    @Test
    public void happyPath5() {
/*
                1
            /       \
           2         3
          / \       / \
         4   5     6   7
        /\   /\   /\   /\
       8  9 10 n 11 12 n n
      / \
     13 14

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, 11, 12, null, null, 13, 14};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 2;
        assertEquals(expected, lca(root, 10, 13));
    }

    @Test
    public void happyPath6() {
/*
                1
            /       \
           2         3
          / \       / \
         4   5     6   7
        /\   /\   /\   /\
       8  9 10 n 11 12 n n
      / \
     13 14

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, 11, 12, null, null, 13, 14};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 2;
        assertEquals(expected, lca(root, 10, 13));
    }

    /*
        HELPER METHODS
     */

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LowestCommonAncestor_4_8.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
