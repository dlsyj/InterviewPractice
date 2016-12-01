package leetcode;
/*There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

 * 	Method: Binary search
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation
 */
public class lc_004_medianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		if (len1 > len2){
			return findMedianSortedArrays(nums2, nums1);
		}
		int left = 0, right = len1 * 2;
		while (left <= right){
			int mid1 = left + (right - left) / 2;
			int mid2 = len1 + len2 - mid1;
			double L1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
			double L2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
			double R1 = mid1 == len1 * 2 ? Integer.MAX_VALUE : nums1[mid1 / 2];
			double R2 = mid2 == len2 * 2 ? Integer.MAX_VALUE : nums2[mid2 / 2];
			// L1 <= R1 && L2 <= R1 && L1 <= R2 && L2 <= R2
			if (L2 > R1){
				// A1's larger half is too small; need to move C1 right
				left = mid1 + 1;
			} else if (L1 > R2){
				// A1's lower half is too big; need to move C1 left
				right = mid1 - 1;
			} else {
				return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
			}
		}
		return -1;
	}
	// Time: O(log(m+n)), Space: O(1)
}
