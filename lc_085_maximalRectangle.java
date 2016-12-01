package leetcode;
/* Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
 * Method: based on 84.Largest Rectangle in Histogram
 * https://www.youtube.com/watch?v=g8bSdXCG-lA
 */

import java.util.*;
public class lc_085_maximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] histogram = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                if (matrix[i][j] == '1'){
                    histogram[j] += 1;
                }else{
                    histogram[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, maximalHistogram(histogram));
        }
        return maxArea;
    }
    
    public int maximalHistogram(int[] heights){
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
