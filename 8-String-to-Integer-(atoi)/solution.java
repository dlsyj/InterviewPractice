public class Solution {
    public int myAtoi(String str) {
        // 1. empty
        if (str == null){
            return 0;
        }
        // 2. discard leading white spaces
        str = str.trim();
        if (str.length() == 0){
            return 0;
        }
        int sign = 1;
        int index = 0;
        // 3. sign 
        if (str.charAt(index) == '+'){
            index ++;
        }else if (str.charAt(index) == '-'){
            sign = -1;
            index ++;
        }
        long num = 0;
        for (;index < str.length(); index++){
            if (str.charAt(index) < '0' || str.charAt(index) > '9'){
                break;
            }
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE){
                break;
            }
        }
        // 4. overflow
        if (num * sign >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) num * sign;
    }
}