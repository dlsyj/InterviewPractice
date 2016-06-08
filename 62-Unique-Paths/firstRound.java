public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0)
            return 0;
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i=0;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
               ans[j] += ans[j-1];
            }
        }
        return ans[n-1];
    }
}