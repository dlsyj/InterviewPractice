package leetcode;
/*Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 * 
 */
import java.util.*;
public class lc_249_groupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        if (strings == null || strings.length == 0){
            return result;
        }
        for (String str : strings){
            String key = "";
            for (int i = 1; i < str.length(); i ++){
                key += String.format("%2d", (str.charAt(i) - str.charAt(i - 1) + 26)%26); 
            }
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        for (String each : map.keySet()){
            System.out.println(each+","+map.get(each));
            result.add(map.get(each));
        }
        return result;
    }
}
