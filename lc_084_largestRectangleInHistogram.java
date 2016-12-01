package leetcode;
/* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * For example,
Given heights = [2,1,5,6,2,3],
return 10.
Method: Stack
https://www.youtube.com/watch?v=ZmnqCZp9bBs
 */

import java.util.*;
public class lc_084_largestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i ++){
            int curr = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && curr <= heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
