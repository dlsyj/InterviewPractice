public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
    		return 0;
    	}
    	int[] ans = new int[grid[0].length];
    	ans[0] = grid[0][0];
    	for (int j=1; j < grid[0].length; j++){
    		ans[j] = ans[j-1]+grid[0][j];
    	}
    	for (int i=1; i < grid.length; i++){
    		for (int j=0; j < grid[0].length; j++){
    			if (j == 0){
    				ans[j] += grid[i][j];
    			} else {
    				ans[j] = Math.min(ans[j],ans[j-1])+grid[i][j];
    			}
    		}
    	}
    	return ans[grid[0].length-1];
    }
}