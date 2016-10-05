public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> result = new ArrayList<Integer>();
	    helper(result, nums, new ArrayList<Integer>(), 0);
	    return result;
	}
	
	public void helper(List<List<Integer>> result, int[] nums, ArrayList<Integer> path, int index){
	    result.add(new ArrayList<Integer>(path));
	    for (int i = index; i < nums.length; i ++){
	        path.add(nums[i]);
	        helper(result,nums,path,i + 1);
	        path.remove(path.size() - 1);
	    }
	}
}