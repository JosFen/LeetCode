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
    private ListNode mergeR(ListNode l1, ListNode l2) { // recursion
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
                l1.next = mergeR(l1.next, l2);
                return l1;
            }
        else {
                l2.next = mergeR(l1, l2.next);
                return l2;
        }
    }

    private ListNode mergeI(ListNode l1, ListNode l2) { // Iteration
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        while (l1 != null && l2 !=null) {
            if(l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        ptr.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next; // To handle 2-node list case

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = sortList(slow.next);
        slow.next = null;
        ListNode l2 =  sortList(head);
        // return mergeR(l1, l2);
        return mergeI(l1, l2);
    }
    
}
