public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            // case 1: nums[mid] == target
            if (nums[mid] == target){
                return true;
            }
            // case 2: right half is sorted
            if (nums[mid] < nums[right]){
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            } else if (nums[right] < nums[mid]){ // case 3: left half is sorted
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            } else {    // case 4: duplicated found 
                right --;
            }
        }
        return false;
    }
}