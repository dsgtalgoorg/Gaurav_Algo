import java.util.ArrayList;
import java.util.List;

public class FirstCommonAncestor {
    public static void main(String[] args) {
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

        findFirstCommonAncestor(t11, t111, t51);
        findFirstCommonAncestor(t11, t81, t101);
        findFirstCommonAncestor(t11, t41, t51);
        findFirstCommonAncestor(t11, t61, t101);
    }

    /*
                      t11(1)
                     /     \
                 t21(2)      t31(3)
                /     \        /     \
              t41(4)  t51(5)  t61(6)  t71(7)
                                      /    \
                                    t81(7)  t91(6)
                                             /     \
                                            t111(4) t101(5)

     */
    private static void findFirstCommonAncestor(TreeNode t11, TreeNode t111, TreeNode t51) {
        List<TreeNode> current = new ArrayList<>();
        if (t11 == null) return;
        current.add(t11.left);
        boolean firstNode = false;
        boolean secondNode = false;
        List<TreeNode> parents = new ArrayList<>();
        while (current.size() > 0) {
            parents = current;
            current = new ArrayList<>();
            for (TreeNode node : parents) {
                if (node.left != null) current.add(node.left);
                if (node.right != null) current.add(node.right);
                if (t111 == node) firstNode = true;
                if (t51 == node) secondNode = true;
            }
        }
        if (firstNode && secondNode) {
            findFirstCommonAncestor(t11.left, t111, t51);
        } else if (firstNode || secondNode) {
            System.out.println(t11.value);
            return;
        } else {
            findFirstCommonAncestor(t11.right, t111, t51);
        }
    }
}
