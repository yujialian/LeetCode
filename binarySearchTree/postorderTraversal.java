/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Command {
    boolean isReady;
    TreeNode node;
    Command(boolean isReady, TreeNode node) {
        this.isReady = isReady;
        this.node = node;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(false, root));
        while(!stack.isEmpty()) {
            Command c = stack.pop();
            if(c.isReady) {
                ans.add(c.node.val);
            } else {
                stack.push(new Command(true, c.node));
                if(c.node.right != null) stack.push(new Command(false, c.node.right));
                if(c.node.left != null) stack.push(new Command(false, c.node.left));
            }
        }
        return ans;
    }
}
