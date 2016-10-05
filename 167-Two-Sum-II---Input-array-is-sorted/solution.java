public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2){
            return result;
        }
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum < target){
                left ++;
            } else if (target < sum){
                right --;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                // break;
            }
        }
        return result;
    }
}