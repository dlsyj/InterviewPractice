public class Solution {
    public void nextPermutation(int[] nums) {
        // The replacement must be in-place, do not allocate extra memory.
        if (nums == null || nums.length <= 1){
            return;
        }
        int i = nums.length-1;
        for (;i > 0; i--){
            //find first number which is smaller than it's after number
            if (nums[i-1] < nums[i]){
                break;
            }
        }
        if (i != 0){    // make sure "first" is not start of nums
            int j = nums.length - 1;
            for (;j >= 0; j--){
                if (nums[j] > nums[i-1]){   // scan from right to find the first element larger than "first"
                    break;
                }
            }
            swap(nums,i-1,j);   // swap them
        }
        reverse(nums,i,nums.length-1);  // reverse all element after i
    }
    
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums,start++,end--);
        }
    }
}