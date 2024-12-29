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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, TreeNode maxNode, TreeNode minNode) {
        if (node == null) return true;

        // in the left branch, INVALID if the node value is greater than the value of max node/parent node of this left subtree:
        if (maxNode != null && maxNode.val <= node.val) return false; 
        // in the right branch, INVALID if the node value is smaller than the value of min/parent node of this right subtree:
        if (minNode != null && minNode.val >= node.val) return false;

        return isValidBST(node.left, node, minNode) && isValidBST(node.right, maxNode, node);
    } 
}
