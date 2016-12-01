package leetcode;
/* Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * 
 */
public class lc_061_rotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        int length = getLength(head);
        k = k % length;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;
        
        for (int i = 0; i < k; i ++){
            head = head.next;
        }
        while (head.next != null){
            head = head.next;
            tail = tail.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
    
    public int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length ++;
            head = head.next;
        }
        return length;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
