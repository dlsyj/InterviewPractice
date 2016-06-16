public class Solution {
    public int findPeakElement(int[] nums) {
       return helper(nums, 0, nums.length -1);
    }
    
    public int helper(int[] nums, int left, int right){
        if (left ==  right){
            return left;
        }
        int mid = left + (rihgt - left);
        if (nums[mid] < nums[mid+1]){
            left = mid+1;
        } else {
            right = mid;
        }
    }
}