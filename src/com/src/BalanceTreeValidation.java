//Check if tree is balance , Maximum difference between two subtree should not be more than one

import java.util.LinkedList;
import java.util.List;

public class BalanceTreeValidation {

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(createListBFS(t1));


        TreeNode t111 = new TreeNode(4);
        TreeNode t101 = new TreeNode(5);
        TreeNode t91 = new TreeNode(6, t111, t101);
        TreeNode t81 = new TreeNode(7);
        TreeNode t41 = new TreeNode(4);
        TreeNode t51 = new TreeNode(5);
        TreeNode t61 = new TreeNode(6);
        TreeNode t71 = new TreeNode(7, t81, t91);
        TreeNode t21 = new TreeNode(2, t41, t51);
        TreeNode t31 = new TreeNode(3, t61, t71);
        TreeNode t11 = new TreeNode(1, t21, t31);
        System.out.println(createListBFS(t11));
    }

    private static boolean createListBFS(TreeNode t1) {
        List<TreeNode> current = new LinkedList<TreeNode>();
        if (t1 != null) {
            current.add(t1);
        }
        Integer min = Integer.MAX_VALUE;
        Integer max = 0;
        while (current.size() > 0) {
            max += 1;
            List<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode node : parents) {
                if (node.left != null) {
                    current.add(node.left);
                }
                if (node.right != null) {
                    current.add(node.right);
                }
                if (node.left == null || node.left == null) {
                    min = Math.min(min, max);
                }
                if (max - min > 1) {
                    return false;
                }
            }
        }
        return max - min <= 1;
    }


}
