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
    public ListNode reverseList(ListNode head) {
        if(null == head || null == head.next )
            return head;
        // setting pointer to second node
        ListNode temp =  head.next;
        // marking 1st node next as null as it would be the last
        head.next = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = head;
            head = temp;
            temp = next;
        }
        return head;
    }
}
