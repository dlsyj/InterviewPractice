public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // <sorted string, raw string>
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        List<List<String>> ans = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0){
            return ans;
        }
        for (int i = 0; i < strs.length; i++){
            char[] rawArr = strs[i].toCharArray();
            Arrays.sort(rawArr);
            String sortedStr = new String(rawArr);
            if (map.containsKey(sortedStr)){
                map.get(sortedStr).add(strs[i]);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sortedStr,list);
            }
        }
        for (String each : map.keySet()){
            ans.add(map.get(each));
        }
        return ans;
    }
}