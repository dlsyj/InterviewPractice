package leetcode;
import java.util.*;

public class lc_001_twoSum {
	/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 * 
	 *Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 * 
	 *Method: HashMap
	 */
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        if(numbers==null||numbers.length<=1) return ans;
        // <key: Targert - nums[i], value: i>
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<numbers.length;i++){
            if(map.containsKey(numbers[i])){
            	// found pair
                ans[0]=map.get(numbers[i])+1;
                ans[1]=i+1;
                return ans;	// prune 
            }else{
                map.put(target-numbers[i],i);
            }
        }
        return ans;
    }
    // Time: O(n), Space: O(n)	
    
    public static void main(String[] args){
    	int[] nums = {2,7,11,15};
    	int target = 9;
    	System.out.println(twoSum(nums,target));
    }
}