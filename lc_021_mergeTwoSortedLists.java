package leetcode;
/*Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * Method: dummy node
 */
public class lc_021_mergeTwoSortedLists {
	// Recursive method
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
        	l1.next = mergeTwoLists(l1.next, l2);
        	return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
	
	// Iterative method
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while(l1 != null && l2 != null) {
            if(l2.val < l1.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        
        if(l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        
        return dummy.next;
	}
}
