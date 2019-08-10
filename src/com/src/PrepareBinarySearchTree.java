// Prepare binary search tree from sorted array

public class PrepareBinarySearchTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        addTree(arr);
    }

    private static void addTree(int[] arr) {
        addTree(arr, 0, arr.length - 1);
    }

    private static TreeNode addTree(int[] arr, int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        TreeNode tree = new TreeNode(arr[mid]);
        tree.left = addTree(arr, 0, mid - 1);
        tree.right = addTree(arr, mid + 1, end);
        return tree;
    }
}
