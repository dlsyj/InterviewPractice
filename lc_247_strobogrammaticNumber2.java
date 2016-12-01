package leetcode;
/* A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"]
 * 
 * Method:
n = 0:   none
n = 1:   0, 1, 8
n = 2:   11, 69, 88, 96
n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986
n = 4:   1001, 6009, 8008, 9006, 1111, 6119, 8118, 9116, 1691, 6699, 8698, 9696, 1881, 6889, 8888, 9886, 1961, 6969, 8968, 9966
 */
import java.util.*;
public class lc_247_strobogrammaticNumber2 {
	public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<String>();
        return helper(n, n, result);
    }
    
    public List<String> helper(int n, int m, List<String> result){
        if (n == 0){
            result.add("");
            return result;
        }
        if (n == 1){
            result.add("0");
            result.add("1");
            result.add("8");
            return result;
        }
        List<String> temp = helper(n - 2, m, result);
        List<String> newResult = new ArrayList<String>();
        for (int i = 0; i < temp.size(); i ++){
            String str = temp.get(i);
            if (n != m){
                newResult.add("0" + str + "0");
            }
            newResult.add("1" + str + "1");
            newResult.add("6" + str + "9");
            newResult.add("8" + str + "8");
            newResult.add("9" + str + "6");
        }
        return newResult;
    }
}
