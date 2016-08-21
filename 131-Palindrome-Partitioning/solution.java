public class Solution {
    public boolean isPalindrome(String str, int index){
        for (int head = 0, tail = index - 1; head <= tail; head++, tail--){
            if (str.charAt(head) != str.charAt(tail)){
                return false;
            }
        }
        return true;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        if (s.equals("")){
            ans.add(new ArrayList<String>());
            return ans;
        }
        for (int i = 0; i < s.length(); i++){
            if (isPalindrome(s,i+1)){
                for (List<String> eachList : partition(s.substring(i+1))){
                    eachList.add(0,s.substring(0,i+1));
                    ans.add(eachList);
                }
            }
        }
        return ans;
    }
}