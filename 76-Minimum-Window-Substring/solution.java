public class Solution {
    public String minWindow(String S, String T){
		String ans = "";
		if (T.length() > S.length()){
			return ans;
		}
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		HashMap<Character,Integer> window = new HashMap<Character,Integer>();
		for (int i = 0; i < T.length(); i++){
			char c = T.charAt(i);
			if (map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
				window.put(c, 0);
			}
		}
		// Now all char in T are in map

		int minLength = Integer.MAX_VALUE;
		int letterCount = 0;
		for (int slow = 0, fast = 0; fast < S.length(); fast++){
			char c = S.charAt(fast);
			if (map.containsKey(c)){
				if (window.get(c) < map.get(c)){
					letterCount ++;
				}
				window.put(c,window.get(c)+1);
			}

			// Shrink the window
			if (letterCount >= T.length()){
				char c2 = S.charAt(slow);
				while (!map.containsKey(c2) || window.get(c2) > map.get(c2)){
					window.put(c2, window.get(c2)-1);
					slow++;
				}
				if (fast - slow + 1 < minLength){
					minLength = fast - slow + 1;
					ans = S.substring(slow,minLength);
				}
				letterCount--;
				window.put(c2,window.get(c2)-1);
				slow++;
			}
		}
		return ans;
	}
}