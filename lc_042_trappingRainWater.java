package leetcode;
/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * Method: DP, two scans, first scan: save highest value from left side
 */
public class lc_042_trappingRainWater {
	public int trap(int[] height) {
        // dp method
        if (height == null || height.length == 0){
            return 0;
        }
        int[]  maxHeight = new int[height.length + 1];
        maxHeight[0] = 0;
        // first scan: save highest value from left side
        for (int i = 0; i < height.length; i++){
            maxHeight[i + 1] = Math.max(height[i],maxHeight[i]);
        }
        int maxValue = 0, maxArea = 0;
        for (int i = height.length - 1; i >= 0; i--){
            maxArea += Math.min(maxValue,maxHeight[i]) > height[i] ? Math.min(maxValue,maxHeight[i]) - height[i] : 0;
            maxValue = Math.max(maxValue,height[i]);
        }
        return maxArea;
    }
}
