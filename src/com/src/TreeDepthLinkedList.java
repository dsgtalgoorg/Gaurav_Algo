//Created multiple LinkedList of tree node , one LinkedList per level

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeDepthLinkedList {

    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t1 = new TreeNode(1, t2, t3);
        List<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
        createListDFS(t1, list, 0);
        System.out.println(list.size());
        List<LinkedList<TreeNode>> list1 = new ArrayList<LinkedList<TreeNode>>();
        createListBFS(list1, t1);
        System.out.println(list1.size());
    }

    private static void createListBFS(List<LinkedList<TreeNode>> list1, TreeNode t1) {
        LinkedList<TreeNode> current = new LinkedList<>();
        if (t1 != null) current.add(t1);

        while (current.size() > 0) {
            list1.add(current);
            LinkedList<TreeNode> newParents = current;
            current = new LinkedList<>();
            for (TreeNode treeNode : newParents) {
                if (treeNode.left != null)
                    current.add(treeNode.left);
                if (treeNode.right != null)
                    current.add(treeNode.right);
            }
        }
    }

    private static void createListDFS(TreeNode t1, List<LinkedList<TreeNode>> list, int i) {
        if (t1 == null) return;
        LinkedList<TreeNode> nodes = null;
        if (list.size() <= i) {
            nodes = new LinkedList<TreeNode>();
            list.add(nodes);
        } else {
            nodes = list.get(i);
        }
        nodes.add(t1);
        createListDFS(t1.left, list, i + 1);
        createListDFS(t1.right, list, i + 1);
    }


}
