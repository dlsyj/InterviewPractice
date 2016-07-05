public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null){
            return 0;
        }
        // create int[] to store the intermidiate value
        int[] ans = new int[triangle.size()];
        for (int i = 0; i < ans.length; i++){
            // store the bottom line of triangle
            ans[i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = triangle.size()-2; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                ans[j] = Math.min(ans[j],ans[j+1])+triangle.get(i).get(j);
            }
        }
        return ans[0];
        
    }
}