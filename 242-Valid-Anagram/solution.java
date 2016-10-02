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
            arr[(int)s.charAt(i)] ++;
        }
        for (int j = 0; j < t.length(); j ++){
            if (arr[(int)t.charAt(j)] <= 0){
                return false;
            }else{
                arr[(int)t.charAt(j)]--;
            }
        }
        return true;
    }
}