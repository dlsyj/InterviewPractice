public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Method 2: DFS/Backtracking
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
       if (nums == null || nums.length == 0){
           return ans;
       }
       dfs(nums,ans,new ArrayList<Integer>(),0);
       return ans;
    }
    public void dfs(int[] nums, List<List<Integer>> ans, ArrayList<Integer> path, int index){
        ans.add(new ArrayList<Integer>(path));
        for (int i = index; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums,ans,path,i+1);
            path.remove(path.size()-1);
        }
    }
}