public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i ++){
            for (int j = 0; j < i; j ++){
                if (dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    continue;
                }
            }
        }
        return dp[s.length() + 1];
    }
}