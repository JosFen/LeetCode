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

/** 2ND: CONSTRUCT & COMPARE 2 NUMBERS */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int num = 0;
        int rev = 0;
        int factor = 1;
        ListNode ptr = head;

        while (ptr != null) {
            num = num * 10 + ptr.val;
            rev = rev + ptr.val * factor;
            factor *= 10;
            ptr = ptr.next;
        }
        return (num == rev);
    }    
}

 /** 1ST: FAST & SLOW POINTERS */
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode slow = head, fast = head;

//         while (fast != null && fast.next != null) {
//             fast = fast.next.next;
//             slow = slow.next;
//         }

//         ListNode tail = reverse(slow);
//         while (tail != null) {
//             if (tail.val != head.val) return false;
//             tail = tail.next;
//             head = head.next;
//         }
//         return true;
//     }

//     public ListNode reverse(ListNode node) {
//         ListNode prev = null;
//         while (node != null) {
//             ListNode tmp = node.next;
//             node.next = prev;
//             prev = node;
//             node = tmp;
//         }
//         return prev;
//     }
// }
