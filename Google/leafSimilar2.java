//O(1) space, o(n) time.
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
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        s1.add(root1);
        s2.add(root2);
        while(!s1.isEmpty() && !s2.isEmpty()) {
            if(dfs(s1) != dfs(s2)) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }
    private int dfs(Stack<TreeNode> s) {
        while(true) {
            TreeNode node = s.pop();
            if(node.left != null) s.push(node.left);
            if(node.right != null) s.push(node.right);
            if(node.left == null && node.right == null) return node.val;
        }

    }
}
