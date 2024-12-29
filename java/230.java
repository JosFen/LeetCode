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
// DFS: time O(n)
class Solution {
    private int answer = -1;
    private int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return this.answer;
    }
    private void inOrder(TreeNode root, int k) {
        if (root == null) return;

        inOrder(root.left, k);
        if (++rank == k) {
            this.answer = root.val;
            return;
        }
        inOrder(root.right, k);
    }
}
