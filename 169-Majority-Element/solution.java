public class Solution {
    // Moore voting algorithm
    public int majorityElement(int[] nums) {
        int count = 0, ans = 0;
        for (int each : nums){
            if (count == 0){
                ans = each;
            }
            if (each != ans){
                count--;
            }else{
                count++;
            }
        }
        return ans;
    }
}