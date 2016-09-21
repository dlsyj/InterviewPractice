public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return result;
        }
        List<Integer> current = new ArrayList<Integer>();
        current.add(nums[0]);
        result.add(current);
        for (int i = 1; i < nums.length; i ++){
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j ++){
                for (List<Integer> each : result){
                    List<Integer> eachNewLine = new ArrayList<Integer>(each);
                    eachNewLine.add(j,nums[i]);
                    newResult.add(eachNewLine);
                }
            }
            result = newResult;
        }
        return result;
    }
}