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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) return 0;

        int currMax = Math.max(root.val, max);
        // return (root.val >= max ? 1 : 0) + dfs(root.left, currMax) + dfs(root.right, currMax); // Note: wrap the whole ternary condition

        int count = (root.val >= max ? 1 : 0);
        count += dfs(root.left, currMax);
        count += dfs(root.right, currMax); 
        return count; 
    }
}
