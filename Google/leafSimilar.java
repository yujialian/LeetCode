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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaft = new ArrayList<>();
        List<Integer> root2Leaft = new ArrayList<>();
        dfs(root1Leaft, root1);
        dfs(root2Leaft, root2);
        return root1Leaft.equals(root2Leaft);
        
    }
    private void dfs(List<Integer> list, TreeNode root) {
        if(root == null) return;
        dfs(list, root.left);
        if(root.left == null && root.right == null) list.add(root.val);
        dfs(list, root.right);
    }
}
