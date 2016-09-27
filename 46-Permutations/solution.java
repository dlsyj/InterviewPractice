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
            List<List<Integer>> newResult = ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j ++){
                for (List<Integer> list : result){
                    List<Integer> currList = new ArrayList<Integer>(list);
                    currList.add(j,nums[i]);
                    newResult.add(currList);
                }
            }
            result = newResult;
        }
        return result;
    }
}