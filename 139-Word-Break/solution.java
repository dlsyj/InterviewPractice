public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i ++){
            for (int j = 0; j < i; j ++){
                if (canBreak[j] && dict.contains(s.substring(j,i))){
                    canBreak[i] = true;
                    continue;
                }
            }
        }
        return canBreak[s.length() + 1];
    }
}