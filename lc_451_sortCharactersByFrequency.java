package leetcode;
/* Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters
 * 
 */
import java.util.*;
public class lc_451_sortCharactersByFrequency {
	public String frequencySort(String s) {
        // O(nlogn) solution based on Heap
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() == 0){
            return sb.toString();
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a,b) ->( b.frequency - a.frequency));
        int[] letters = new int[256];
        for (char c : s.toCharArray()){
            letters[c]++;
        }
        for (int i = 0; i < letters.length; i ++){
            if (letters[i] > 0){
                pq.offer(new Tuple((char) i, letters[i]));
            }
        }
        System.out.println(pq.size());
        while (!pq.isEmpty()){
        //for (int i = 0; i < pq.size(); i ++){   // pq.size() is changing
            Tuple each = pq.poll();
            for (int j = 0; j < each.frequency; j ++){
                sb.append(each.val);
            }
        }
        return sb.toString();
        
    }
    public class Tuple{
        char val;
        int frequency;
        public Tuple(char v, int f){
            this.val = v;
            this.frequency = f;
        }
    }
    
    
    // O(n) bucket sort solution based on HashMap
    public String frequencySort2(String s) {
        
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() == 0){
            return sb.toString();
        }
        int maxCount = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        // O(n) time, O(n) space
        for (char c : s.toCharArray()){
            freqMap.putIfAbsent(c,0);
            freqMap.put(c,freqMap.get(c) + 1);
            maxCount = Math.max(maxCount, freqMap.get(c));
        }
        // O(n) time, O(n) space
        List<Character>[] table = new List[maxCount + 1];
        for (char c : freqMap.keySet()){
            if (table[freqMap.get(c)] == null){
                table[freqMap.get(c)] = new ArrayList<Character>();  
            }
            table[freqMap.get(c)].add(c);
        }
        for (int i = table.length - 1; i >= 0; i --){
            if (table[i] != null){
                for (char c : table[i]){
                    for (int j = 0; j < i; j ++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
