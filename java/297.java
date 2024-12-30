/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// DFS: O(n)
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderSerialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("") || data.charAt(0) == 'N') return null;
        String[] vals = data.split(",");
        Queue<String> queue = new ArrayDeque<>(List.of(vals));
        return preorderDeserialize(queue);
    }

    private void preorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return ;
        }

        sb.append(root.val).append(",");
        preorderSerialize(root.left, sb);
        preorderSerialize(root.right, sb);
    }

    private TreeNode preorderDeserialize(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = preorderDeserialize(queue);
        root.right = preorderDeserialize(queue);

        return root;
    }
}


// BFS: 0(n)
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        StringBuilder sb = new StringBuilder();
        // ArrayDeque does not allow the insertion of null elements. 
        // Attempting to add null results in a NullPointerException, while LinkedList allows inserting Null
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) sb.append("N,");
            else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("") || data.charAt(0) == 'N') return null;
        String[] vals = data.split(",");
        // if(vals[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < vals.length; i += 2) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(node.left);
            }
            if (!vals[i + 1].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(vals[i + 1]));
                queue.offer(node.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
