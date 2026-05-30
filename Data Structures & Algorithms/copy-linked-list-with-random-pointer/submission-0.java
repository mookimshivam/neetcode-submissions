/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(null == head)
            return head;

        // map to track random
        Map<Node,Node> map = new HashMap<>();

        Node mainHead  = head;
        // 1st node copy
        Node copyHead = new Node(head.val);
        Node copy = copyHead;

        // put main and copy node in map
        map.put(mainHead, copyHead);
        // start copying from 2nd node
        mainHead = mainHead.next;
        // create copy of each node
        while(mainHead != null){
            Node temp = new Node(mainHead.val);
            map.put(mainHead, temp);

            // set next of copy nodes
            copy.next = temp;
            copy = copy.next;

            mainHead = mainHead.next;
        }
        // set last node next as null
        copy.next = null;

        mainHead = head;
        copy = copyHead;
        // for each node's random get is respective copy node
        while(mainHead != null){
            if(null == mainHead.random)
                copy.random = null;
            else
                copy.random = map.get(mainHead.random);
            mainHead = mainHead.next;
            copy = copy.next;
        }
        return copyHead;
    }
}
