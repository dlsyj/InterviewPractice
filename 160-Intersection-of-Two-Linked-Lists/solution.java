/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != headB){
            headA = headA.next != null ? headA.next : headB;
            headB = headB.next != null ? headB.next : headA;
        }
        return headA;
    }
}