public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k){
            throw new Error();
        }
        int pos = quickselect(nums, nums.length - k + 1, 0, nums.length - 1);
        return nums[pos];
    }
    public int quickselect(int[] nums, int k, int left, int right){
        int i = left, j = right;
        int pivot = nums[right];
        while (i < j){
            if (pivot < nums[i]){
                j --;
                swap(nums, i, j);
            }else{
                i ++;
            }
        }
        swap(nums, i, right);
        int currNum = i - left + 1;
        if (currNum < k){
            quickselect(nums, k - currNum, i + 1, right);
        }else if (k < currNum){
            quickselect(nums, k, 0, i - 1);
        }else{
            return i;
        }
    }
    
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}