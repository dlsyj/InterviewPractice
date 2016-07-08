public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        if (nums == null || nums.length == 0){
            return ans;
        }
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
            if (map.get(key) > Math.floor(nums.length/3)){
                ans.add(key);
            }
        }
        return ans;
    }
}