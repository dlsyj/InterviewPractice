public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[2] result = new int[2](); 
        // <key: Targert - nums[i], value: i>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums == null || nums.length == 0){
            return result;
        }
        for (int i = 0; i < nums.length; i ++){
            if (map.containsKey(nums[i])){
                // found pair
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
}