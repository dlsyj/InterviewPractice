public class Solution {
    public int trap(int[] height) {
        // Corner Case
        if (height == null || height.length == 0){
            return 0;
        }
        int max = 0;
        int ans = 0;
        int[] container = new int[height.length];
        // First scan: from left to right
        for (int i = 0; i < height.length; i++){
            container[i] = max;
            max = Math.max(max,height[i]);
        }
        // Second scan: from right to left
        max = 0;
        for (int i = height.length-1; i >= 0; i--){
            // Find the lower MAX values from two sides
            container[i] = Math.min(max,container[i]);
            max = Math.max(max,height[i]);
            ans += container[i]-height[i] > 0 ? container[i]-height[i] : 0;
        }
        return ans;
    }
}