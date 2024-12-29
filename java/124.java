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
// Optimized (DP): O(n)
class Solution {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return this.result;
    }

    private int findMaxPath(TreeNode root) {
        if (root == null) return 0;

        int leftMax = Math.max(findMaxPath(root.left), 0); // find max sum of current root's left subtree first, down-to-top
        int rightMax = Math.max(findMaxPath(root.right), 0);

        // record the max path sum found so far by adding max path sum from both subtrees and current node val:
        this.result = Math.max(this.result, root.val + leftMax + rightMax);

        // return the max subtree path sum including the current node
        return root.val + Math.max(leftMax, rightMax);
    }
}


// Brute Force DFS O(n^2): search/calculate max on every node top-to-down
class Solution {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return this.result;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        // find the max sum on the current node:
        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        this.result = Math.max(this.result, root.val + leftMax + rightMax);

        // find the max sum on the child nodes:
        dfs(root.left);
        dfs(root.right);
    }

    private int getMax(TreeNode root) {
        if (root == null) return 0;
        int leftSubMax = getMax(root.left);
        int rightSubMax = getMax(root.right);
        // Greedy: Only the larger sum of the left/right subtrees on current node will be used,
        // which means recursively find the larger child node and add it up:
        int pathSum = root.val + Math.max(leftSubMax, rightSubMax);
        return Math.max(0, pathSum); // ignore the negative path sum
    }
}
