public class Solution {
    public List<Integer> getRow(int rowIndex) {
       List<Integer> ans = new ArrayList<Integer>();
       // Corner Case
       if (rowIndex < 0){
           return ans;
       }
       for (int i = 0; i < rowIndex+1; i++){
           ans.add(1);
           for (int j = i-1; j > 0; j--){
               ans.set(j,ans.get(j)+ans.get(j-1));
           }
       }
       return ans;
    }
}