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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode ptr = sentinel;
        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // System.out.println("sum :" + sum);
            ptr.next = new ListNode(sum%10);
            sum /= 10;
            // System.out.println("sum :" + sum + " ; ptr.val :"  + ptr.val);
            ptr = ptr.next;
        }
        if (sum > 0) {
            ptr.next = new ListNode(sum%10);
            sum /= 10;
        }
        //  System.out.println("sum :" + sum + " ; ptr.val :"  + ptr.val);

        return sentinel.next;
    } 
}
