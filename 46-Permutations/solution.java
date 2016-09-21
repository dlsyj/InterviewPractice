public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        List<Integer> first = new ArrayList<Integer>();
        first.add(nums[0]);
        result.add(first);
        for (int i = 1; i < nums.length; i ++){
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j ++){
                for (List<Integer> each : result){
                    List<Integer> newEach = new ArrayList<Integer>(each);
                    newEach.add(j,nums[i]);
                    newResult.add(newEach);
                }
            }
            result = newResult;
        }
        return result;
    }
}