public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3){
            return ans;
        }
        Arrays.sort(nums);  // O(nlogn)
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]){ // skip the duplicated one
               continue;
            } else {
                int target = 0-nums[i];
                int left = i+1, right = nums.length-1;
                while (left < right){
                    if (nums[left] + nums[right] == target){
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1]){ // skip the duplicated one
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]){   // skip the duplicated one
                            right --;
                        }
                        left++;
                        right--;
                    }else if (nums[left] + nums[right] < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}