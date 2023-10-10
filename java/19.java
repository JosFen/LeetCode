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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head, r = head;
        while (n > 0) {
            r = r.next;
            n--;
        }
        while (r != null && r.next != null) {
            l = l.next;
            r = r.next;
        }
        // if n = length of linked list, remove the first node:
        if (r == null) head = head.next; 
        else l.next = l.next.next;

        return head;      
    }
}
