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
        ListNode temp_l1 = l1;
        ListNode temp_l2 = l2; 

        int current = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;

        ListNode resHead = new ListNode(current);
        ListNode temp_curr = resHead;

        temp_l1 = temp_l1.next;
        temp_l2 = temp_l2.next;
        while(temp_l1 != null && temp_l2 != null){
            int sum = (temp_l1.val + temp_l2.val + carry);
            current = sum % 10;
            carry = sum / 10;
            ListNode temp = new ListNode(current);
            temp_curr.next = temp;
            temp_curr = temp_curr.next;

            temp_l1 = temp_l1.next;
            temp_l2 = temp_l2.next;
        }

        while(temp_l1 != null){
            int sum = (temp_l1.val + carry);
            current = sum % 10;
            carry = sum / 10;
            ListNode temp = new ListNode(current);
            temp_curr.next = temp;
            temp_curr = temp_curr.next;
            temp_l1 = temp_l1.next;
        }

        while(temp_l2 != null){
            int sum = (temp_l2.val + carry);
            current = sum % 10;
            carry = sum / 10;
            ListNode temp = new ListNode(current);
            temp_curr.next = temp;
            temp_curr = temp_curr.next;
            temp_l2 = temp_l2.next;
        }
        if(carry > 0){
            ListNode temp = new ListNode(carry);
            temp_curr.next = temp;
            temp_curr = temp_curr.next;
        }
        temp_curr.next = null;
        return resHead;
    }
}
