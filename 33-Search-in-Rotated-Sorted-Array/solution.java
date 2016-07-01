public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            // case 1: target == nums[mid]
            if (target == nums[mid]){
                return mid;
            }
            // case 2: right half is well sorted
            if (nums[mid] < nums[right]){
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            // case 3: left half is well sorted
            }else{
                if (target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}