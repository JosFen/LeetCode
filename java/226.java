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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        if (root.left != null || root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }
}

// if invertTree's return value is used (more succinct):
class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;

    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = invertTree(right);
    root.right = invertTree(left);
    return root;
  }
}
