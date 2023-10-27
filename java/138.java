/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// 2ND VERSION: recursion:
class Solution {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;
    if (map.containsKey(head))
      return map.get(head);

    Node newNode = new Node(head.val);
    map.put(head, newNode);
    newNode.next = copyRandomList(head.next);
    newNode.random = copyRandomList(head.random);
    return newNode;
  }

  private Map<Node, Node> map = new HashMap<>();
}

// 1ST VERSION: iterative:
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Map<Node, Node> copyListMap = new HashMap<>();
        Node cur = head;

        // copy node and val
        while (cur != null) {
            copyListMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            copyListMap.get(cur).next = copyListMap.get(cur.next);
            copyListMap.get(cur).random = copyListMap.get(cur.random);
            cur = cur.next;
        }

        return copyListMap.get(head);
    }
}
