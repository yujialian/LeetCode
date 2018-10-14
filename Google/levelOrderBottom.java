//107
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//BFS
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                layer.add(queue.poll().val);
            }
            ans.add(0, layer);
        }
        return ans;
    }
}

//DFS
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        levelCount(ans, root, 0);
        return ans;
    }
    private void levelCount(List<List<Integer>> ans, TreeNode root, int level) {
        if(root == null) return;
        if(level >= ans.size()) ans.add(0, new LinkedList<Integer>());
        levelCount(ans, root.left, level + 1);
        levelCount(ans, root.right, level + 1);
        ans.get(ans.size() - level - 1).add(root.val);
    }
}
