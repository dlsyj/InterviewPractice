public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int leftPointer = 0, rightPointer = nums.length - 1;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0){
                // found 0, put it in the beginning
                int temp = nums[i];
                nums[i] = nums[leftPointer];
                nums[leftPointer] = temp;
                leftPointer++
            }else if (nums[i] == 2){
                // found 2, put it in the end
                int temp = nums[i];
                nums[i] = nums[rightPointer];
                nums[rightPointer] = temp;
                i--; 
                rightPointer--;
            }
        }
    }
}