import java.util.ArrayList;
import java.util.List;

public class BSTSequences {

    public static void main(String[] args) {
        TreeNode t41 = new TreeNode(1);
        TreeNode t51 = new TreeNode(7);
        TreeNode t21 = new TreeNode(6, t41, t51);
        TreeNode t31 = new TreeNode(13);
        TreeNode t11 = new TreeNode(10, t21, t31);
        List<List<TreeNode>> result = findBSTSequence(t11);
        System.out.println("End");
    }

    private static List<List<TreeNode>> findBSTSequence(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        result.add(current);
        List<TreeNode> parent = new ArrayList<>();
        while (current.size() > 0) {
            result = addFinalCombination(addCurrentCombination(current), result);
            parent = current;
            current = new ArrayList<TreeNode>();
            for (TreeNode node : parent) {
                if (node.left != null) current.add(node.left);
                if (node.right != null) current.add(node.right);
            }
        }
        return result;
    }

    private static List<List<TreeNode>> addCurrentCombination(List<TreeNode> current) {
        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode treeNode1 : current) {
            for (TreeNode treeNode2 : current) {
                if (treeNode1 != treeNode2) {
                    list = new ArrayList<>();
                    list.add(treeNode1);
                    list.add(treeNode2);
                }
            }
            result.add(list);
        }
        return result;
    }


    private static List<List<TreeNode>> addFinalCombination(List<List<TreeNode>> current, List<List<TreeNode>> result) {
        List<List<TreeNode>> finalList = new ArrayList<List<TreeNode>>();
        for (List<TreeNode> currentList : current) {
            List<TreeNode> list = new ArrayList<>();
            for (List<TreeNode> resultList : result) {
                list.addAll(resultList);
                list.addAll(currentList);
                finalList.add(list);
                list = new ArrayList<>();
            }
        }
        printAll(finalList);
        return finalList;
    }

    private static void printAll(List<List<TreeNode>> finalList) {
        if (finalList == null) return;

        for (List<TreeNode> nodeList : finalList) {
            System.out.println("===================================");
            for (TreeNode node : nodeList) {
                System.out.println(node.value);
            }
            System.out.println("===================================");
        }
    }

}
