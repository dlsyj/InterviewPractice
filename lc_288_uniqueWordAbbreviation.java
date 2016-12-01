package leetcode;
/* An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
 * 
 */
import java.util.*;
public class lc_288_uniqueWordAbbreviation {
	HashMap<String, String> map;        // <Abbreviation, raw format string>
    
    public lc_288_uniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<String, String>();
        for (String each : dictionary){
            String key = getAbbreviation(each);
            if (map.containsKey(key)){  // if abbreviation is already there, set value to null
                if (!map.get(key).equals(each)){
                    map.put(key, "");   // because it contains duplicates in dictionary
                }
            }else{
                map.put(key, each);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getAbbreviation(word);
        return !map.containsKey(key) ||map.get(key).equals(word);   // easy to forget, check no other word
    }
    
    public String getAbbreviation(String word){
        if (word.length() <= 2){
            return word;
        }
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }
}
