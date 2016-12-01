package leetcode;
/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 * 
 */
public class lc_142_linkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = head;
        while (slow != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
