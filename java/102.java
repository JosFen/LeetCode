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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));

        while(!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode currNode = queue.poll(); 
                currLevel.add(currNode.val);

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            result.add(currLevel);
        }

        return result;
    }
}
