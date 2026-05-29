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
        int len = 0;
        // find element count
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        // remove first-element
        if(len == n)
            return head.next;
        // position from start 0-based
        int position = len - n; 
        temp = head;
        // Take to node before the one to be removed
        for(int i = 0; i < position-1 ; i++){
            temp = temp.next;
        }
        // reset the next to jump one element 
        temp.next = temp.next.next;

        return head;
    }
}
