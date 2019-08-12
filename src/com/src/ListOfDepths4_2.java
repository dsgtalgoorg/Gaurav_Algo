import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class ListOfDepths4_2 {

    public List<List<TreeNode>> listOfNodesAtEachDepth(TreeNode root) {
        List<List<TreeNode>> output = new LinkedList<>();
        if (root != null) {
            List<TreeNode> sublist = new LinkedList<>();
            sublist.add(root);
            output.add(sublist);

            while (sublist.size() != 0) {
                sublist = buildSublist(sublist);
                if (sublist.size() > 0) output.add(sublist);
            }
        }
        return output;
    }

    private List<TreeNode> buildSublist(List<TreeNode> parentList) {
        List<TreeNode> sublist = new LinkedList<>();
        for (TreeNode node : parentList) {
            if (node.left != null) sublist.add(node.left);
            if (node.right != null) sublist.add(node.right);
        }
        return sublist;
    }


    /*
        TESTS
     */



    @Test
    public void emptyTree() {
        Integer[] arr = { null };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        List<List<TreeNode>> result = listOfNodesAtEachDepth(root);
        List<List<TreeNode>> expected = new LinkedList<>();

        assertArrayEquals(expected.toArray(), result.toArray());
    }



    @Test
    public void singleton() {
        Integer[] arr = { null, 1 };
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        List<List<TreeNode>> result = listOfNodesAtEachDepth(root);
        List<List<TreeNode>> expected = new LinkedList<>();

        List<TreeNode> level0 = new LinkedList<>();
        level0.add(root);

        expected.add(level0);

        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void happyPath() {
        /*
                1
            /       \
           2          3
          / \         / \
         4   5       6   7
        /    /           /\
       8    9           10 11

         */

        Integer[] arr = { null, 1, 2, 3, 4, 5, 6, 7, 8, null, 9, null, null, null, 10, 11};
        TreeNode root = TreeUtility.buildBinaryTree(arr);

        List<List<TreeNode>> result = listOfNodesAtEachDepth(root);
        List<List<TreeNode>> expected = new LinkedList<>();



        List<TreeNode> level0 = new LinkedList<>();
        level0.add(root);
        List<TreeNode> level1 = new LinkedList<>();
        level1.add(root.left);
        level1.add(root.right);
        List<TreeNode> level2 = new LinkedList<>();
        level2.add(root.left.left);
        level2.add(root.left.right);
        level2.add(root.right.left);
        level2.add(root.right.right);
        List<TreeNode> level3 = new LinkedList<>();
        level3.add(root.left.left.left);
        level3.add(root.left.right.left);
        level3.add(root.right.right.left);
        level3.add(root.right.right.right);



        expected.add(level0);
        expected.add(level1);
        expected.add(level2);
        expected.add(level3);


//        COMMENT OUT TO PRINT LINKED LIST
//        result.stream().forEach(list -> {
//            System.out.println("-----------");
//            list.stream().forEach((node) -> System.out.println(node.val));
//        });


        assertArrayEquals(expected.toArray(), result.toArray());
    }


    /*
        HELPER METHODS
     */

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ListOfDepths4_2.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
