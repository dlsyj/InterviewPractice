package leetcode;
/*Reverse a singly linked list.
 * 
 */
public class lc_206_reverseLinkedLists {
	public ListNode reverseList(ListNode head) {
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
