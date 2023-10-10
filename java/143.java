/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode l2 = reverse(mid);
        
        head = merge(head, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 != null || l2 != null) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode tmp = l1.next;
            l1.next = merge(l2, tmp);
            return l1;
        }
        return null;

    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }
}
