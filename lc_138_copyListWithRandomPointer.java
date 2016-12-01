package leetcode;
/*A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
 * 
 * Method:// (1) first scan to copy next pointer 1->1'->2->2'->3->3'
          // (2) second scan to copy random 
          // (3) split node 1->2->3, 1'->2'->3'
 */
public class lc_138_copyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
        // (1) first scan to copy next pointer 1->1'->2->2'->3->3'
        // (2) second scan to copy random 
        // (3) split node 1->2->3, 1'->2'->3'
        if (head == null){
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
	
	private void copyNext(RandomListNode head){
	    while (head != null){
	        RandomListNode newNode = new RandomListNode(head.label);
	        newNode.random = head.random;   // Easy to forget
	        newNode.next = head.next;
	        head.next = newNode;
	        head = newNode.next;
	    }
	}

	private void copyRandom(RandomListNode head){
	    while (head != null){
	        if (head.next.random != null){
	            head.next.random = head.random.next;
	        }
	        head = head.next.next;
	    }
	}

	private RandomListNode splitList(RandomListNode head){
	    RandomListNode newHead = head.next;
	    while (head != null){
	        RandomListNode temp = head.next;
	        head.next = temp.next;
	        head = head.next;
	        if (temp.next != null){
	            temp.next = temp.next.next;
	        }
	    }
	    return newHead;
	}
}


