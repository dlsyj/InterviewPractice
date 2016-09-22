public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int leftPointer = 0, rightPointer = nums.length - 1;
        for (int i = 0; i < nums.length; ){
            if (nums[i] == 0){
                // found 0, put it in the beginning
                swap(nums, i, leftPointer++);
                i ++;
            }
            if (nums[i] == 2){
                // found 2, put it in the end
                swap(nums, i, rightPointer--);
            } else {
                i ++;
            }
        }
    }
    
    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}