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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode temp = head;
        // set max value as per constraint 
        ListNode defaultVal = new ListNode(1001);
        
        Boolean processingOver = false;
        while(!processingOver){
            ListNode currMin = defaultVal;
            int minIndex = 0;
            processingOver = true;
            // find the minimum valued node
            for(int i = 0; i < lists.length; i++){
                if(lists[i] != null && lists[i].val <= currMin.val){
                    currMin = lists[i];
                    minIndex = i;
                    processingOver = false;
                }
            }
            // if all lists null means processed break
            if(processingOver)
                break;
            // add the node to the result list
            temp.next = currMin;
            temp = temp.next;
            // remove the processed node from the lists linked-list
            lists[minIndex] = lists[minIndex].next;
            temp.next = null;
        }
        return head.next;
    }
}
