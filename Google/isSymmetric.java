//101
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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        return r1.val == r2.val && isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);
    }
}

//Iteratively
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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            if(r1 == null && r2 == null) continue;
            if(r1 == null || r2 == null) return false;
            if(r1.val != r2.val) return false;
            queue.offer(r1.left);
            queue.offer(r2.right);
            queue.offer(r1.right);
            queue.offer(r2.left);
        }
        return true;
    }
}
