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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l = head;
        ListNode r = head.next;

        while (r != null) {
            if (l.val == r.val) {
                l.next = r.next;
            } 
            else {
                l = l.next;
            }
            r = r.next;
        }
        return head;
        
    }
}
