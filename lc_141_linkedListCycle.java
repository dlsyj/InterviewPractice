package leetcode;
/*Given a linked list, determine if it has a cycle in it.

	Follow up:
	Can you solve it without using extra space?
 * 
 * Method: two pointers
 */
public class lc_141_linkedListCycle {
	public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
