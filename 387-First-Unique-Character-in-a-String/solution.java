public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (set.contains(curr)) {
                map.remove(curr);
            } else {
                map.put(curr, i);
                set.add(curr);
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}