public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length == 0){
            return -1;
        }
        int[] freq = new int[26];
        int[] loc = new int[26];
        for (int i = 0; i < s.length; i ++){
            char curr = s.charAt(i);
            freq[curr - 'a'] ++;
            loc[curr - 'a'] = i;
        }
        int result = -1;
        for (int i = 0; i < 26; i ++){
            if (freq[i] == 1){
                result = result == -1? loc[i] : Math.min(loc[i], result);
            }
        }
        return result;
    }
}