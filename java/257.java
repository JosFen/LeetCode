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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        // dfs(root, "", paths);
        dfsSB(root, new StringBuilder(), paths);
        return paths;
    }
    private void dfsSB(TreeNode root, StringBuilder sb, List<String> paths) {
        if (root == null) return;

        int len = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) {  // If it's a leaf node
            paths.add(sb.toString());
        } else {
            sb.append("->");
            dfsSB(root.left, sb, paths);
            dfsSB(root.right, sb, paths);
        }
        sb.setLength(len);
    }
    // private void dfs(TreeNode root,  String path, List<String> paths) {
    //     if (root.left == null && root.right == null) {  // If it's a leaf node
    //         paths.add(path + root.val);
    //     } else {
    //         path += root.val + "->";
    //         if (root.left != null) {
    //             dfs(root.left, path, paths);
    //         }
    //         if (root.right != null) {
    //             dfs(root.right, path, paths);
    //         }
    //     }
    // }
}
