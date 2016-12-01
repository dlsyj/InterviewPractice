package leetcode;
/* Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 * 
 */
public class lc_075_sortColors {
	public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2){
            return;
        }
        int leftPointer = 0, rightPointer = nums.length - 1;
        for (int i = leftPointer; i <= rightPointer;){	// Attention here
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[leftPointer];
                nums[leftPointer] = temp;
                i ++;
                leftPointer ++;
            }else if (nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[rightPointer];
                nums[rightPointer] = temp;
                rightPointer --;
            }else{
                i ++;
            }
        }
    }
}
