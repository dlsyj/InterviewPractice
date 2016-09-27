/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode d = dummy;
        int num = 0;
        while (l1 != null || l2 != null){
            num /= 10;
            if (l1 != null){
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                num += l2.val;
                l2 = l2.next;
            }
            d.next = new ListNode(num % 10);
            d = d.next;
        }
        if (num >= 10){
            d.next = new ListNode(1);
        }
        return dummy.next;
        // Time: O(Math.max(l1.length, l2.length)), Space: O(1)
    }
}