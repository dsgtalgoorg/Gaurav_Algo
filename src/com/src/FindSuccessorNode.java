public class FindSuccessorNode {

    public static void main(String[] args) {
       /* TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t1 = new TreeNode(1, t2, t3); */
        TreeNode successorNode = null;
        // findSuccessor(t1,t2,false ,successorNode);
        boolean lastVisited = false;
        TreeNode t41 = new TreeNode(0);
        TreeNode t51 = new TreeNode(5);
        TreeNode t61 = new TreeNode(20);
        TreeNode t71 = new TreeNode(80);
        TreeNode t21 = new TreeNode(2, t41, t51);
        TreeNode t31 = new TreeNode(51, t61, t71);
        TreeNode t11 = new TreeNode(10, t21, t31);
        // findSuccessor(t11,t31,false ,successorNode);
        //findSuccessor(t11,t21,false ,successorNode);
        //findSuccessor(t11,t71,false ,successorNode);
        findSuccessor(t11, t61, lastVisited, successorNode);
        //findSuccessor(t11,t41,false ,successorNode);


    }


    private static TreeNode findSuccessor(TreeNode root, TreeNode searchNode, boolean lastVisited, TreeNode successorNode) {
        if (root == null || searchNode == null) return null;
        if (lastVisited && successorNode == null && root.value > searchNode.value) {
            System.out.println(root.value);

            // successorNode=root;
            // lastVisited=false;
            return root;
        }
        if (root == searchNode) lastVisited = true;
        findSuccessor(root.left, searchNode, lastVisited, successorNode);
        findSuccessor(root.right, searchNode, lastVisited, successorNode);
        return successorNode;
    }
}


