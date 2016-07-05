public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;
        int subsetNum = 1 << length;    // total number of subset
        for (int i = 0; i < subsetNum; i++){
            boolean illegal = false;
            List<Integer> eachSubset = new ArrayList<Integer>();
            for (int j = 0; j < length; j++){
                if ((i>>j)&1 == 1){
                    if(j>0&&num[j]==num[j-1]&&(i>>(j-1)&1)==0){
                        illegal = true;
                        break;
                    }else{
                        eachSubset.add(nums[j]);
                    }
                }
            }
            if (!illegal){
                ans.add(eachSubset);
            }
        }
        return ans;
    }
}