package leetcode;
/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	Find the minimum element.
	
	You may assume no duplicate exists in the array.
 * Method: Binary Search
 */
public class lc_153_findMinimumInRotatedSortedArray {
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
