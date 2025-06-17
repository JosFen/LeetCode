/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// DFS:
class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) return visited.get(node);

        Node nodeCopy = new Node(node.val);
        visited.put(node, nodeCopy);

        for (Node n : node.neighbors) {
            nodeCopy.neighbors.add(cloneGraph(n)); 
        }

        return nodeCopy;
    }
}

// BFS:
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        visited.put(node, new Node(node.val));
        q.offer(node);

        while(!q.isEmpty()) {
            Node currNode = q.poll();
            for (Node n : currNode.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val));
                    q.offer(n);
                }
                visited.get(currNode).neighbors.add(visited.get(n));
            }
        }
        return visited.get(node);  
    }
}
