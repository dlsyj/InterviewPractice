package leetcode;
/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * Method: Iteration: Dummy node + priority queue; Recursion: Partition + MergeTwoLists
 */
import java.util.*;
public class lc_023_mergeKsortedLists {
	// method 1: merge two sorted lists
	public ListNode mergeKLists(ListNode[] lists){
		return partition(lists, 0, lists.length - 1);
	}
	public ListNode partition(ListNode[] lists, int left, int right){
		if (left == right){
			return lists[left];
		} else if (left < right){
			int mid = left + (right - left) / 2;
			ListNode leftNode = partition(lists, left, mid);
			ListNode rightNode = partition(lists, mid + 1, right);
			return mergeTwoLists(leftNode, rightNode);
		} else {
			return null;
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if (l1 == null){
			return l2;
		}
		if (l2 == null){
			return l1;
		}
		if (l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	
	// method 2: Dummy node + priority queue
	public ListNode mergeKLists2(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
