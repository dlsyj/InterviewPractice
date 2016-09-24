public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            System.out.print(nums[mid]);
            if(nums[mid] < nums[right]) {
                right = mid;
                System.out.println(nums[right]);
            } else {
                left = mid + 1;
                System.out.println(nums[left]);
            }
        }
        return nums[left];
    }
}