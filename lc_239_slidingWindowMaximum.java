package leetcode;
/*Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
	For example,
	Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
	
	Window position                Max
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
	 1 [3  -1  -3] 5  3  6  7       3
	 1  3 [-1  -3  5] 3  6  7       5
	 1  3  -1 [-3  5  3] 6  7       5
	 1  3  -1  -3 [5  3  6] 7       6
	 1  3  -1  -3  5 [3  6  7]      7
	Therefore, return the max sliding window as [3,3,5,5,6,7].
	
	Note: 
	You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
	
	Follow up:
	Could you solve it in linear time?
 * 
 * Method: monotonic queue
 We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n) as each element is put and polled once.

At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means

If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]
 
 deque head					tail
 	--------------------------
 ->								->
 <-								<-
 	--------------------------
 	^						^
 	|						|
   local max
   i-(k-1)					i
 
 */
import java.util.*;
public class lc_239_slidingWindowMaximum {
	public int[] maxSlidingWindow(int[] numbers, int k) {
		if (numbers == null || numbers.length == 0){
			return new int[0];
		}
		int len = numbers.length;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int[] result = new int[len - k + 1];
		int resultIndex = 0;
		for (int i = 0; i < numbers.length; i ++){
			// remove element whose index is out of range k
			while (!deque.isEmpty() && deque.peek() < i - (k - 1)){
				deque.poll();
			}
			// compare to the last element to remove smaller elements in range k
			while (!deque.isEmpty() && numbers[deque.peekLast()] < numbers[i]){
				deque.pollLast();
			}
			// add index in deque rather than content
			deque.addLast(i);
			if (i >= k-1){	// Don't forget to judge i
				result[resultIndex++] = numbers[deque.peek()];
			}
		}
		return result;
	}
}
