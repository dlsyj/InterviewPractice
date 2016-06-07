public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0){
            return ans;
        }
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<Integer>(), ans, 0);
        return ans;
    }
   
    public void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> ans, int start){
        if (target < 0){
            return;
        } else if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        } else {
            int pre = -1;
            for (int i=start; i<candidates.length; i++){
                int num = candidates[i];
                if (num == pre){
                    continue;
                }
                pre = num;
                path.add(num);
                dfs(candidates, target-num, path, ans, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}