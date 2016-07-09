public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0){
    		return ans;
    	}
    	int[] count = new int[2];
    	int[] temp = new int[2];
    
    	// get top 2 frequent elements
    	temp[0] = 0;
    	temp[1] = 1;
    	for (int num : nums){
    		if (num == temp[0]){
    			count[0]++;
    		}else if (num == temp[1]){
    			count[1]++;
    		}else if (count[0] == 0){
    			temp[0] = num;
    			count[0] = 1;
    		}else if (count[1] == 0){
    			temp[1] = num;
    			count[1] = 1;
    		}else{
    			count[0]--;
    			count[1]--;
    		}
    	}
    
    	int[] reCount = new int[2];
    	for (int num : nums){
    		if (num == temp[0]){
    			reCount[0]++;
    		}else if (num == temp[1]){
    			reCount[1]++;
    		}
    	}
    	for (int j = 0; j < 2; j++) {
    	    if (reCount[j] > nums.length/3 && !ans.contains(temp[j])) ans.add(temp[j]);
        }  
    	
    	return ans;
    }
}