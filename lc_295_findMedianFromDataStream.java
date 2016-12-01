package leetcode;
/* Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2
 * Method: two heap, small left is max heap, large right half is min heap, small left may have one more element than right
 */
import java.util.*;
public class lc_295_findMedianFromDataStream {
	private boolean currEven = true;
    // small is for smaller half and it's max heap
    private PriorityQueue<Integer> small = new PriorityQueue<Integer>(Collections.reverseOrder());  // max heap
    private PriorityQueue<Integer> large = new PriorityQueue<Integer>();    // minheap
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (currEven){  // small has one more after inserting this new number
            large.offer(num);
            small.offer(large.poll());
        }else{          // firstly insert into small (n + 2), then pop from small and insert into large
            small.offer(num);
            large.offer(small.poll());
        }
        currEven = !currEven;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(currEven){
            return (small.peek() + large.peek())/2.0;
        }else{
            return small.peek();
        }
    }
}
