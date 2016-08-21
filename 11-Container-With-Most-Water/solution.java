public class Solution {
    public int maxArea(int[] height) {
        int maxAns = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            maxAns = Math.max(maxAns,Math.min(height[left],height[right])*(right-left));
            if (height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxAns;
    }
}