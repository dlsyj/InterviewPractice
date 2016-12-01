package leetcode;
/* Given a string containing only digits, restore it by returning all possible valid IP address combinations.
For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * Method: 3-loop divides the string s into 4 substring: s1, s2, s3, s4. Check if each substring is valid.
In isValid, strings whose length greater than 3 or equals to 0 is not valid; 
or if the string's length is longer than 1 and the first letter is '0' then it's invalid; 
or the string whose integer representation greater than 255 is invalid.
 */
import java.util.*;
public class lc_093_restoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i <= 3 && i < len - 2; i++){    // first cut
            for (int j = i + 1; j <= i + 3 && j < len - 1; j++){    // second cut
                for (int k = j + 1; k <= j + 3 && k < len; k++){    // third cut
                    String first = s.substring(0,i), second = s.substring(i,j), third = s.substring(j,k), fourth = s.substring(k);
                    if (isValid(first) && isValid(second) && isValid(third) && isValid(fourth)){
                        result.add(first+"."+second+"."+third+"."+fourth);
                    }
                }
            }
        }
        return result;
    }
    
    public boolean isValid(String num){
        if (num.length() > 3 || num.length() ==0 || (num.charAt(0) == '0' && num.length() > 1) || Integer.parseInt(num) > 255){
            return false;
        }
        return true;
    }
}
