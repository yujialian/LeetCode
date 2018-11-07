//337
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] max = robHelper(root);
        return Math.max(max[0], max[1]);
    }
    private int[] robHelper(TreeNode root) {
        int[] max = new int[2];
        if(root == null) return max;
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        max[0] = root.val + left[1] + right[1];
        max[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return max;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] max = robHelper(root);
        return Math.max(max[0], max[1]);
    }
    private int[] robHelper(TreeNode node) {
        int[] max = new int[2];
        if(node == null) return max;
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);
        max[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        max[1] = node.val + left[0] + right[0];
        return max;
    }
}
