package leetcode;
/* Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Method: (1)
 */
public class lc_189_rotateArray {
	
	public void rotate1(int[] nums, int k) {
		swap(nums, 0, nums.length - 1);
	    k = k % nums.length;
	    swap(nums, 0, k - 1);
	    swap(nums, k, nums.length - 1);
	}
	
	public void swap(int[] nums, int start, int end){
		while (start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start ++;
			end --;
		}
	}
	
	
}
