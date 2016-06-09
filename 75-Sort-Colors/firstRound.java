public class Solution {
    public void sortColors(int[] nums) {
    	if (nums == null || nums.length == 0){
    		return;
    	}
    	// Two pointers
    	int low = 0, high = nums.length-1;
    	for (int i=low; i<=high;){
    		if (nums[i] == 0){
    			// swap nums[i] and nums[low], then i and low both ++
    			int temp = nums[i];
    			nums[i] = nums[low];
    			nums[low] = temp;
    			i++;
    			low++;
    		} else if (nums[i] == 2){
    		    // swap nums[i] ans nums[high], then high--
    			int temp = nums[i];
    			nums[i] = nums[high];
    			nums[high] = temp;
    			high--;
    		} else {
    		    i++;
    		}
    	}
    }
}