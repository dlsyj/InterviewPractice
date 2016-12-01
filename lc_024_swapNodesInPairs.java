package leetcode;
/* Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 * 
 */
public class lc_024_swapNodesInPairs {
	//Iterative solution
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        while (head.next != null && head.next.next != null){
            ListNode n1 = head.next, n2 = head.next.next;
            // covert from "head->n1->n2" to "head->n2->n1"
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            // move to next pair
            head = n1;
        }
        return dummy.next;
    }
	
	// Recursive solution
	public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
