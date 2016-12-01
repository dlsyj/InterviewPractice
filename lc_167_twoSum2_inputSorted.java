package leetcode;
/* Given an array of integers that is already sorted in ASCENDING order, 
 * find two numbers such that they add up to a specific target number.
	The function twoSum should return indices of the two numbers such that they add up to the target, 
	where index1 must be less than index2. 
	Please note that your returned answers (both index1 and index2) are not zero-based.
	
	You may assume that each input would have exactly one solution.
	
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
 * 
 */
public class lc_167_twoSum2_inputSorted {
	public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
            	// return index or element in array
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target){
                left ++;
            } else {
                right --;
            }
        }
        return result;
    }
}
