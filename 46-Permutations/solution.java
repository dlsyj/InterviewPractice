public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        backTracking(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    public void backTracking(List<List<Integer>> result, int[] nums, List<Integer> current, int index){
        if (current.size() == nums.length){
            result.add(current);
            return;
        }
        for (int j = 0; j <= current.size(); j ++){
            List<Integer> newCopy = new ArrayList<Integer>(current);
            newCopy.add(j, nums[index]);
            backTracking(result, nums, newCopy, index + 1);
        }
    }
}