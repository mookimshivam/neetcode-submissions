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
        int carry = 0;

        ListNode resHead = new ListNode(0);
        ListNode tail = resHead;

        while(l1 != null || l2 != null || carry != 0){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = (a + b + carry);
            int current = sum % 10;
            carry = sum / 10;
            ListNode temp = new ListNode(current);
            tail.next = temp;
            tail = tail.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        tail.next = null;

        return resHead.next;
    }
}
