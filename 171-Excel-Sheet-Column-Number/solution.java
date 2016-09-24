public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        if (s == null || s.length() == 0){
            return result;
        }
        
        for ( int i = 0; i < s.length(); i ++){
            int num = s.charAt(i) - 'A' + 1;
            result = num + result * 26;
        }
        return result;
    }
}