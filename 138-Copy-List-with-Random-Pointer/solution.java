/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        copyNextNode(head);
        copyRandomNode(head);
        return splitNode(head);
    }
    
    public void copyNextNode(RandomListNode head){
        while (head != null){
            RandomListNode newHead = new RandomListNode(head.label);
            newHead.random = head.random;
            newHead.next = head.next;
            head.next = newHead;
            head = head.next.next;
        }
    }
    
    public void copyRandomNode(RandomListNode head){
        while (head != null){
            if (head.next.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    public RandomListNode splitNode(RandomListNode head){
        // 1->1'->2->2'->3->3'
        RandomListNode newNode = head.next;
        while (head != null){
            RandomListNode copy = head.next;
            head.next = copy.next;
            head = head.next;
            if (copy.next != null){
                copy.next = copy.next.next;
            }
        }
        return newNode;
    }
}