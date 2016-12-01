package leetcode;
/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
	For example,
	Given [3,2,1,5,6,4] and k = 2, return 5.
	Note: 
	You may assume k is always valid, 1 ≤ k ≤ array's length.
 * Method 1: quickSelect, O(N) running time + O(1) memory
 * Method 2: max heap, O(NlgK) running time + O(K) memory
 * 
 */
import java.util.*;
public class lc_215_KthLargestElementinArray {
	public int findKthLargest2(int[] nums, int k) {
        // min heap, O(NlgK) running time + O(K) memory
        final PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums){
            pq.offer(num);
            if (pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
	
	
	
	
	public int findKthLargest(int[] nums, int k) {
        // O(N) running time + O(1) memory
		if (nums == null || nums.length < k){
			throw new Error();
		}
        int len = nums.length;
        int pos = quickSelect(nums,0,len - 1,len - k +1);
        return nums[pos];
    }
    
    // return the index of kth smallest number
    public int quickSelect(int[] nums, int low, int high, int k){
        int i = low, j = high, pivot = nums[high];
        while (i < j){
            if (nums[i] > pivot){
                j--;
                swap(nums,i,j);
            } else {
                i++;
            }
        }
        
        swap(nums,i,high);	// swap the pivot from right to the right place
        // count the nums that are <= pivot from low
        int m = i - low + 1;
        if (m == k){
            return i;
        } else if (m > k){
            return quickSelect(nums,low,i - 1, k);
        } else {
            return quickSelect(nums,i+1,high,k-m);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
