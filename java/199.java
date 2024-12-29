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

// 2nd version, recursion
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addRightmostNode(root, 0, result);
        return result;
    }

    private void addRightmostNode(TreeNode root, int currLevel, List<Integer> result) {
        if (root == null) return;
        // if the currLevel (root level is 0) equals the size of result, then the rightmost node is not added yet; 
        // otherwise (once: currLevel == result.size() + 1), the rightmost node has already been added, 
        // then move to next level starting from right child:
        if (currLevel == result.size()) result.add(root.val);
        addRightmostNode(root.right, currLevel + 1, result);
        addRightmostNode(root.left, currLevel + 1, result);
    }
}

// 1st version: iterative using Queue
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));

        while (!queue.isEmpty()) {
            // result.add(queue.peek().val);
            final int currSize = queue.size();
            for (int i = currSize; i > 0; i--) {
                TreeNode node = queue.poll();
                if (i == currSize) result.add(node.val);
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
        }

        return result;
    }
}

