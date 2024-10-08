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

// Iterative solution:
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode preL = dummy;

        for (int i = 0; i < left - 1; i++) {
            preL = preL.next;
        }
        ListNode tail = preL.next;
        ListNode r = tail;

        for (int i = 0; i < right - left; i++) {
            r = tail.next;
            tail.next = r.next;
            r.next = preL.next;
            preL.next = r;
        }
        return dummy.next;
    }
}

// Recursive solution:
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        if (left == 1) return reverse(head, right);

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverse(ListNode head, int right) {
        if (right == 1) return head;

        ListNode tail = reverse(head.next, right - 1);
        ListNode currNext = head.next;
        head.next = currNext.next;
        currNext.next = head;

        return tail;
    }
}
