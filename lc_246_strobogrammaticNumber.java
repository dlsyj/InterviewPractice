package leetcode;
/* A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic
 * 
 */
import java.util.*;
public class lc_246_strobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        map.put(0,0);
        int len = num.length();
        int left = 0, right = len - 1;
        while (left <= right){
            int leftNum = num.charAt(left) - '0';
            int rightNum = num.charAt(right) - '0';
            if (map.containsKey(leftNum) && map.containsKey(rightNum) && map.get(leftNum) == rightNum){
                left ++;
                right --;
            }else{
                return false;
            }
        }
        return true;
    }
	
	// 1 line solution
	public boolean isStrobogrammatic2(String num) {
	    for (int i=0, j=num.length()-1; i <= j; i++, j--)
	        if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
	            return false;
	    return true;
	}
}
