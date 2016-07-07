public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);  // Easy to forget
        int minDiff = Integer.MAX_VALUE; 
        int closestSum = 0;
        for (int i = 0; i < nums.length; i++){
            int left = i+1, right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(target-sum);
                if (diff < minDiff){
                    minDiff = diff;
                    closestSum = sum;
                }
                if (sum < target){
                    left ++;
                }else if (sum > target){
                    right --;
                }else{
                    return sum;
                }
            }
        }
        return closestSum;
    }
}