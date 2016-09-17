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
        int count = k;
        ListNode node = head;
        ListNode last = node;
        while (node != null && count > 0){
            count --;
            node = node.next;
        }
        if (count == 0){
            node.next = reverseKGroup(node.next, k);
            return reverseNode(last);
        } else {
            return last;
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