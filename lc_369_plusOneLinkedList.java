package leetcode;
/* Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
 * Method: Naive method is to reverse linkedlist and plus one then reverse it back
 */
public class lc_369_plusOneLinkedList {
	public ListNode plusOne(ListNode head) {
        if (helper(head) == 0){
            return head;
        }
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }
    
    public int helper(ListNode head){
        if (head == null){
            return 1;
        }
        int sum = head.val + helper(head.next);
        head.val = sum % 10;
        return sum / 10;
    }
}
