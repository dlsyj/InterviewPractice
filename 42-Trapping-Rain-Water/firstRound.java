public class Solution {
    public int trap(int[] height) {
       if (height == null || height.length == 0){
           return 0;
       }
       int left = 0, right = height.length - 1;
       int ans = 0;
       while (left < right){
           int min = Math.min(height[left], height[right]);
           if (height[left] == min){
               // Now min is lower boundary of pool
               left ++;
               while (left < right && height[left] < min){
                   ans += min - height[left];
                   left++;
               }
           }else{
               right --;
               while (left < right && height[right] < min){
                   ans += min - height[right];
                   right--;
               }
           }
       }
       return ans;
    }
}