public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Method 1: Bit Manipulation
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int length = nums.length;
        int subsetNum = 1 << length;    // total number of subset
        for (int i = 0; i < subsetNum; i++){
            List<Integer> eachSubset = new ArrayList<Integer>();
            for (int j = 0; j < length; j++){
                if (i & (1<<j) != 0){
                    eachSubset.add(nums[j]);
                }
            }
            ans.add(eachSubset);
        }
        return ans;
    }
}