package leetcode;
/* Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n^2)?
 * Method: find min and max, and HashSet to record reflecting point
 */
import java.util.*;
public class lc_356_lineReflection {
	public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<String>();
        for (int[] pair : points){
            set.add(pair[0] + "," + pair[1]);
            min = Math.min(min, pair[0]);
            max = Math.max(max, pair[0]);
        }
        int sum = min + max;
        for (int[] pair : points){
            if (!set.contains((sum - pair[0])+","+pair[1])){
                return false;
            }
        }
        return true;
    }
}
