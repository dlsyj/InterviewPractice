public class Solution {
    public int myAtoi(String str) {
        // 1. check empty
        if (str == null){
            return 0;
        }
        
        // 2. discard leading white spaces
        str = str.trim();
        if (str.length() == 0){
            return 0;
        }
        
        // 3. handle sign 
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+'){
            index ++;
        }else if (str.charAt(index) == '-'){
            sign = -1;
            index ++;
        }
        
        // 4. convert number and avoid overflow
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
       
        if (num * sign >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) num * sign;
    }
}