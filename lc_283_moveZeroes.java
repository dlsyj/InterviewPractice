package leetcode;
/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 *
 *  Discuss with interviewer: (1)can I copy the array? what is benefit? (2)if the array is null what should I do?
 */
public class lc_283_moveZeroes {
	
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int insertPos = 0;
        for (int num: nums){
            if (num != 0){
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length){
            nums[insertPos++] = 0; 
        } 
    }
	
	public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int currPos = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[currPos];
                nums[currPos++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
