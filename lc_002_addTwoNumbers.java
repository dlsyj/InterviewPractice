package leetcode;
/*You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4), Output: 7 -> 0 -> 8
 * 
 * Method: Dummy node
 */

public class lc_002_addTwoNumbers {
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
	// Time: O(Math.max(l1.length, l2.length)), Space: O(1)
}
