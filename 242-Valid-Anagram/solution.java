public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null){
            return s == t;
        }
        int[] arr = new int[26];
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i ++){
            arr[s.charAt(i) - 'a'] ++;
        }
        for (int j = 0; j < t.length(); j ++){
            if (arr[t.charAt(j) - 'a'] <= 0){
                return false;
            }else{
                arr[t.charAt(j) - 'a']--;
            }
        }
        return true;
    }
}