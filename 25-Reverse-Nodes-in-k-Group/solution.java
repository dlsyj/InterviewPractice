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
        while (curr != null && count < k){
            count ++;
            prev = curr;
            curr = curr.next;
        }
        if (count == k){
            prev.next = null;
            reverseNode(head);
            head.next = reverseKGroup(curr,k);
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