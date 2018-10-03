/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Command {
    boolean cmd;
    TreeNode node;
    Command(boolean cmd, TreeNode node) {
        this.cmd = cmd;
        this.node = node;
    }
}
class Solution {   
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(false, root));
        while(!stack.isEmpty()) {
            Command c = stack.pop();
            
            if(c.cmd) {
                ans.add(c.node.val);
            } else {
                assert(!c.cmd);
                if(c.node.right != null) {
                    stack.push(new Command(false, c.node.right));
                } 
                if(c.node.left != null){
                    stack.push(new Command(false, c.node.left));
                }
                stack.push(new Command(true, c.node));
            }
        }
        return ans;
    }
}
