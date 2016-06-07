public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        dfs(k,n,ans, new ArrayList<Integer>(), 1);
        return ans;
    }
    
    public void dfs(int k, int n, List<List<Integer>> ans, ArrayList<Integer> path, int start){
        
        if (path.size() == k && n == 0){
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = start; i<=9; i++){
            path.add(i);
            dfs(k,n-i,ans,path,i+1);
            path.remove(path.size()-1);
        }
    }
    
}