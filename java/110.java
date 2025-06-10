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

// v3: remove private balanced variable
 class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1; // check signal -1 (imbalanced)
    }
    
    private int dfs(TreeNode node) {
        if (node == null ) return 0;

        int lh = dfs(node.left);
        if (lh == -1) return -1; //return -1 all the way if any subtree is imbalanced
        int rh = dfs(node.right);
        if (rh == -1) return -1; //return -1 all the way if any subtree is imbalanced

        if (Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}


// v2:
class Solution {
    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }
    
    private int dfs(TreeNode node) {
        if (node == null || !balanced) return 0; // return early if already imbalanced

        int lh = dfs(node.left);
        int rh = dfs(node.right);
        if (Math.abs(lh - rh) > 1) balanced = false;

        return 1 + Math.max(lh, rh);
    }
}


// v1: 
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
