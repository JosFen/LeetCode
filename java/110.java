/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int lh = dfs(node.left);
        int rh = dfs(node.right);
        if (Math.abs(lh - rh) > 1) balanced = false;

        return 1 + Math.max(lh, rh);
    }
}
