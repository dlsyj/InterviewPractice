public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Method 2: DFS/Backtracking
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // corner case
        if (nums == null || nums.length == 0){
            return ans;
        }
        dfs(nums,ans,new ArrayList<Integer>(),0);
        return ans;
    }
    public void dfs(int[] nums, List<List<Integer>> ans, ArrayList<Integer> path, int index){
        // Exit Condition
        if (index == nums.length){
            ans.add(new ArrayList<Integer>(path));
            return;
        }else{
            dfs(nums,ans,path,index+1); // current element is not in path
            path.add(nums[index]);
            dfs(nums,ans,path,index+1); // current element is in path
            path.remove(path.size()-1); // remove the current element
        }
    }
}