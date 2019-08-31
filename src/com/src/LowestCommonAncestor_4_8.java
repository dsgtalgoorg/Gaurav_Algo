import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("Duplicates")
public class LowestCommonAncestor_4_8 {
    public TreeNode lca(TreeNode root, int val1, int val2) {
//        return lcaRecurser(root, val1, val2, false, false);
        return lcaRecurser2(root, val1, val2, null, null);
    }

    private TreeNode lcaRecurser2(TreeNode node, int val1, int val2, TreeNode n1, TreeNode n2) {
        if (node == null) return null;
        if (node.val == val1 || node.val == val2) {
            return node;
        }
        TreeNode someNode = lcaRecurser2(node.left, val1, val2, n1, n2);
        if (someNode != null) {
            if (someNode.val == val1) {
                n1 = someNode;
            } else {
                n2 = someNode;
            }
        }

        someNode = lcaRecurser2(node.right, val1, val2, n1, n2);

        if (someNode != null) {
            if (someNode.val == val1) {
                n1 = someNode;
            } else {
                n2 = someNode;
            }
        }

        if (n1 != null && n2 != null) {
            return node;
        }
        if (n1 != null || n2 != null) {
            return n1 != null ? n1 : n2;
        }
        else return null;
    }

    private TreeNode lcaRecurser(TreeNode node, int val1, int val2, boolean found1, boolean found2) { // 1st attempt -  DOES NOT WORK !!
        if (node == null) {
            return null;
        }

        if (found1 && found2) {
            return node;
        }

        if (node.val == val1 && !found1) {
            return node;
        }

        if (node.val == val2 && !found2) {
            return node;
        }

        TreeNode leftNode = lcaRecurser(node.left, val1, val2, found1, found2);

        if (leftNode!= null && leftNode.val == val1 && !found1) {
            found1 = true;
        } else if (leftNode!= null &&  leftNode.val == val2 && !found2) {
            found2 = true;
        }

        TreeNode rightNode = lcaRecurser(node.right, val1, val2, found1, found2);
        if (rightNode!= null && rightNode.val == val1 && !found1) {
            found1 = true;
        } else if (rightNode!= null &&  rightNode.val == val2 && !found2) {
            found2 = true;
        }

        return node;
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

        assertNull(lca(root, 1, 2));
    }

    @Test
    public void singleton() {
        Integer[] arr = { null, 1 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 1;
        assertNull(lca(root, 4, 11));

    }

    @Test
    public void happyPath1() {
/*
                1
            /       \
           2          3
          / \        /  \
         4   5      6    7
        /\   /\    /\    /\
       8  9 10 11 12 13  n n
      / \
     14 15

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 14, 15};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 2;
        assertEquals(expected, lca(root, 4, 11).val);
//        assertEquals(expected, lcaBrute(root, 10, 13));
    }

    @Test
    public void happyPath2() {
 /*
                1
            /       \
           2          3
          / \        /  \
         4   5      6    7
        /\   /\    /\    /\
       8  9 10 11 12 13  n n
      / \
     14 15

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 14, 15};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 1;
        assertEquals(expected, lca(root, 10, 13).val);
//        assertEquals(expected, lcaBrute(root, 9, 11));
    }

    @Test
    public void happyPath3() {
  /*
                1
            /       \
           2          3
          / \        /  \
         4   5      6    7
        /\   /\    /\    /\
       8  9 10 11 12 13  n n
      / \
     14 15

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 14, 15};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 4;
        assertEquals(expected, lca(root, 15, 9).val);
//        assertEquals(expected, lcaBrute(root, 12, 7));
    }

    @Test
    public void happyPath4() {
/*
                1
            /       \
           2          3
          / \        /  \
         4   5      6    7
        /\   /\    /\    /\
       8  9 10 11 12 13  n n
      / \
     14 15
 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 14, 15};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 1;
        assertEquals(expected, lca(root, 9, 6).val);
    }

    @Test
    public void happyPath5() {
/*
                1
            /       \
           2          3
          / \        /  \
         4   5      6    7
        /\   /\    /\    /\
       8  9 10 11 12 13  n n
      / \
     14 15

 */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 14, 15};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        int expected = 1;
        assertEquals(expected, lca(root, 2, 3).val);
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

        int expected = 4;
        assertEquals(expected, lca(root, 13, 9).val);
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
