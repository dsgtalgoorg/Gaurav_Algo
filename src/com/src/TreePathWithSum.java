import java.util.HashMap;

public class TreePathWithSum {
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(pathWIthSum(t1, 7));
    }

    private static Integer pathWIthSum(TreeNode t1, int i) {
        return pathWIthSum(t1, i, 0, new HashMap<Integer, Integer>());
    }

    private static Integer pathWIthSum(TreeNode root, int targetSum, int currentSum, HashMap<Integer, Integer> cache) {
        if (root == null) return 0;

        currentSum += root.value;
        int sum = currentSum - targetSum;

        int totalCounts = cache.getOrDefault(sum, 0);

        if (targetSum == currentSum) {
            totalCounts++;
        }
        System.out.println(root.value + " " + totalCounts);
        incrementCache(cache, currentSum, 1);
        totalCounts += pathWIthSum(root.left, targetSum, currentSum, cache);
        totalCounts += pathWIthSum(root.right, targetSum, currentSum, cache);
        incrementCache(cache, currentSum, -1);

        return totalCounts;
    }

    private static void incrementCache(HashMap<Integer, Integer> cache, int currentSum, int num) {
        int newCount = cache.getOrDefault(currentSum, 0) + num;
        if (newCount == 0) {
            cache.remove(currentSum);
        } else {
            cache.put(currentSum, newCount);
        }
    }
}


/**
 * 1
 * /    \
 * 2         3
 * /   \      /  \
 * 4    5     6   7
 **/