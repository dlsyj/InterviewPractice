/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        ListNode prev = null;
        while (node != null && count < k){
            count ++;
            prev = node;
            node = node.next;
        }
        if (count == k){
            prev.next = null;
            reverseNode(head);
            head.next = reverseKGroup(node,k);
            return prev;
        } else {
            return head;
        }
        

    }
    public ListNode reverseNode(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}