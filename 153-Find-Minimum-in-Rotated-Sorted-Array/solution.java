public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[lo]) return nums[lo];
        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[lo]) {
                hi = mid + 1;
            } else {
                lo = mid;
            }
        }
        return Math.min(nums[lo],nums[hi]);
    }
}