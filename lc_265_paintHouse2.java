package leetcode;
/* There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
 * Method: DP
 */
public class lc_265_paintHouse2 {
	public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0){
            return 0;
        }
        int prevMin = 0, prevSec = 0, prevIdx = -1;
        for (int i = 0; i < costs.length; i ++){
            // Attention: currMin and currSec are MAX_VALUE in each i loop
            int currMin = Integer.MAX_VALUE, currSec = Integer.MAX_VALUE, currIdx = -1;
            for (int j = 0; j < costs[0].length; j ++){
                costs[i][j] += (prevIdx == j? prevSec : prevMin);
                if (costs[i][j] < currMin){	//when val < min, 
                    currSec = currMin;
                    currMin = costs[i][j];
                    currIdx = j;
                }else if(costs[i][j] < currSec){	//when min<=val< secMin
                    currSec = costs[i][j];
                }
            }
            prevMin = currMin;
            prevIdx = currIdx;
            prevSec = currSec;
        }
        return prevMin;
    }
}	
