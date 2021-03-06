public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
        	return 0;
        }
        int low = 0;
        int high = nums.length-1;
        while (low < high){
        	int mid = low + (high - low)/2;
        	if (nums[low] < nums[high]){
        		return nums[low];
        	} else {
        		if (nums[low] <= nums[mid]){
        			low = mid+1;
        		} else {
        			high = mid;
        		}
        	}
        }
        return nums[low];
    }
}