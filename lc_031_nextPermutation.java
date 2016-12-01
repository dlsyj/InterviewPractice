package leetcode;
/* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * 
 */
public class lc_031_nextPermutation {
	public void nextPermutation(int[] nums) {
        // find two adjacent elements, where n[i-1] < n[i]
        int i = nums.length - 1;
        for (;i > 0; i --){
            if (nums[i-1] < nums[i]){
                break;
            }
        }
        if (i != 0){
            // swap (i-1, x), where x is index of the smallest number in [i, n)
            int j = nums.length - 1;
            for(;j >= i; j --){
                if (nums[i - 1] < nums[j]){
                    break;
                }
            }
            swap(nums, i - 1, j);
        }
        reverse(nums, i, nums.length - 1);
    }
    
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public void reverse(int[] nums, int left, int right){
        while(left <= right){
            swap(nums, left ++, right --);
        }
    }
}
