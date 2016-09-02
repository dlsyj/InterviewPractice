public class Solution {
    public boolean isPalindrome(String str){
        int startIndex = 0, endIndex = str.length() - 1;
        while (startIndex <= endIndex){
            if (str.charAt(startIndex) != str.charAt(endIndex)){
                return false;
            }
            startIndex ++;
            endIndex --;
        }
        return true;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s.equals("")){
            result.add(new ArrayList<String>());
            return result;
        }
        for (int i = 0; i < s.length(); i++){
            if (isPalindrome(s.substring(0,i+1))){
                for (List<String> eachList : partition(s.substring(i+1))){
                    eachList.add(0,s.substring(0,i+1));
                    result.add(eachList);
                }
            }
        }
        return result;
    }
}