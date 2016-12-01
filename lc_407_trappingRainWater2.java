package leetcode;
/* Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.

 * Method: fill in from outer boundary and use min heap to find lowest in the outer boundary
 */
import java.util.*;
public class lc_407_trappingRainWater2 {
	// put Cell into min heap
    public class Cell{
        int x, y, h;
        Cell(){}
        Cell(int xx, int yy, int hh){
            x = xx;
            y = yy;
            h = hh;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0){
            return 0;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a,b) -> (a.h - b.h));
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] visited = new int[m][n];
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        // add boundary into heap
        // first and last row
        for (int j = 0; j < n; j ++){
            pq.offer(new Cell(0,j,heightMap[0][j]));
            visited[0][j] = 1;
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[m - 1][j] = 1;
        }
        // first column and last column
        for (int i = 0; i < m; i ++){
            pq.offer(new Cell(i,0,heightMap[i][0]));
            visited[i][0] = 1;
            pq.offer(new Cell(i,n - 1, heightMap[i][n - 1]));
            visited[i][n - 1] = 1;
        }
        
        int result = 0;
        while (!pq.isEmpty()){
            Cell currLeast = pq.poll(); // current least cell
            for (int[] dir : dirs){
                int newX = currLeast.x + dir[0];
                int newY = currLeast.y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && visited[newX][newY] == 0){
                    visited[newX][newY] = 1;    // mark it visited
                    pq.offer(new Cell(newX,newY,Math.max(currLeast.h,heightMap[newX][newY])));
                    result += Math.max(0,currLeast.h - heightMap[newX][newY]);
                }
            }
        }
        return result;
    }
}
