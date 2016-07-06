import java.util.SortedSet; // the return value of subset is SortedSet(Interface) type
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       // subset in TreeSet will return nums [lower,upper)
       // Corner Case
       if (nums == null || nums.length < 2 || k < 1 || t < 0){
           return false;
       }
       SortedSet<Long> windowNumSet = new TreeSet<Long>();
       for (int i = 0; i < nums.length; i++){
           SortedSet<Long> setReturned = windowNumSet.subSet((long)nums[i] - t, (long)nums[i] + t + 1);    // [lower,upper)
           if (!setReturned.isEmpty()){
               return true;
           }
           if (i >= k) windowNumSet.remove((long)nums[i-k]);
           windowNumSet.add((long)nums[i]);
       }
       return false;
    }
}