package leetcode;
/* Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].

 * 
 */
import java.util.*;
public class lc_281_zigzagIterator {
Queue<Iterator<Integer>> queue = new LinkedList<>();
    
    public lc_281_zigzagIterator (List<Integer> v1, List<Integer> v2) {
        if (!v1.isEmpty()){
            queue.offer(v1.iterator());
        }
        if (!v2.isEmpty()){
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> curr = queue.poll();
        int result = curr.next();
        if (curr.hasNext()){
            queue.offer(curr);
        }
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
