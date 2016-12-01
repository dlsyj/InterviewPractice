package leetcode;
/* Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 * Method: Iterator<List<Integer>> Iterator<Integer>
 * https://discuss.leetcode.com/topic/31467/java-iterator-solution-explained
 */
import java.util.*;
public class lc_251_flatten2DVector {
	public class Vector2D implements Iterator<Integer> {
	    Iterator<List<Integer>> iter2d;
	    Iterator<Integer> row;
	    
	    public Vector2D(List<List<Integer>> vec2d) {
	        if (vec2d == null || vec2d.size() == 0){
	            return;
	        }
	        iter2d = vec2d.iterator();
	        row = iter2d.next().iterator();
	        getNextRow();   // ensure row iterator is pointing to a none empty list so i call the getNextRow() method.
	    }
	    
	    private void getNextRow(){
	        while (!row.hasNext() && iter2d.hasNext()){
	            row = iter2d.next().iterator();
	        }
	    }
	    
	    @Override
	    public Integer next() {
	        int next = row.next();
	        getNextRow();   // easy to forget
	        return next;
	    }

	    @Override
	    public boolean hasNext() {
	        return row != null && row.hasNext();
	    }
	}
}
