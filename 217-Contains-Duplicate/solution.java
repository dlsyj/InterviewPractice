public class Solution {
    public  boolean containsDuplicate(int[] nums) {
         Set<Integer> set = new HashSet<Integer>();
         for (int each : nums){
             if(!set.add(each)){
                 return true;
             }
         }
         return false;
     }
}