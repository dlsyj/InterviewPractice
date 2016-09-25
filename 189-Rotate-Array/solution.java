public class Solution {
    public void rotate(int[] nums, int k) {
	    swap(nums, 0, nums.length - 1);
	    swap(nums, 0, k);
	    swap(nums, k + 1, nums.length - 1);
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