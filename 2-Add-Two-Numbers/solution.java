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
        while (c1 != null || c2 != null){
            num /= 10;
            if (c1 != null){
                num += c1.val;
                c1 = c1.next;
            }
            if (c2 != null){
                num += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(num%10);
            d = d.next;
        }
        if (num /10 == 1){
            d.next = new ListNode(1);
        }
        return dummy.next;
    }
}