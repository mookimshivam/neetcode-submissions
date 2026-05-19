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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode head1 = list1, head2 = list2;

        while(head1 != null && head2 != null){
            if(head1.val == head2.val){
                curr.next = head1;
                head1 = head1.next;
                curr = curr.next;

                curr.next = head2;
                head2 = head2.next;
                curr = curr.next;
            }
            else if(head1.val < head2.val){
                curr.next = head1;
                head1 = head1.next;
                curr = curr.next;
            }
            else{
                curr.next = head2;
                head2 = head2.next;
                curr = curr.next;
            }
        }
        if(head1 != null)
            curr.next = head1;
        if(head2 != null)
            curr.next = head2;

        return head.next;
    }
}