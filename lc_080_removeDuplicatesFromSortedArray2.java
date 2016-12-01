package leetcode;
/* Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * 
 */
public class lc_080_removeDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        for (int n : nums){
            if (count < 2 || n > nums[count - 2]){
                nums[count++] = n;
            }
        }
        return count;
    }
}
