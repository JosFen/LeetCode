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
    private int rootIdx = 0;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int l, int r) {
        if (l > r) return null;
        
        int rootVal = preorder[rootIdx++];
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, l, inorderIndexMap.get(rootVal) - 1);
        root.right = build(preorder, inorderIndexMap.get(rootVal) + 1, r);

        return root;
    }
}
