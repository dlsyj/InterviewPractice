public class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int n:nums){
            if(!map.containsKey(n)){
               int left = map.containsKey(n-1) ?  map.get(n-1):0;
               int right = map.containsKey(n+1) ? map.get(n+1):0;
               int sum = left+right+1;  // lenght of sequence containing n
               map.put(n,sum);
               ans = Math.max(ans,sum); // update global max length
               map.put(n-left,sum); // update max length of left boundary
               map.put(n+right,sum);
            }else{
                // duplicate found
                continue;
            }
        }
        return ans;
    }
}