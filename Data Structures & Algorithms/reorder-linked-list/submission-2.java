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
    public void reorderList(ListNode head) {
        int len = 0;
        // if just 1 or 2 element no point 
        if(head.next == null || head.next.next == null)
            return;

        // getting count of elements
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = head;
        // splitting into 2-lists
        for(int i = 0; i < (len/2); i++){
            secondHalf = secondHalf.next;
        }
        // breaking link b/w two lists
        ListNode prev = secondHalf;
        secondHalf = secondHalf.next;
        prev.next = null;

        // reversing 2nd half of list
        ListNode p1 = secondHalf;
        ListNode p2 = p1.next;
        p1.next = null;
        while(p2 != null){
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        secondHalf.next = null;
        secondHalf = p1;
        // merging the elements of both list alternately
        while(secondHalf != null){
            ListNode holdFirst = firstHalf.next;
            ListNode holdSecond = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = holdFirst;
            firstHalf = holdFirst;
            secondHalf = holdSecond;
        }
    }
}
