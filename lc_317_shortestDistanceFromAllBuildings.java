package leetcode;
/* You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7
 * 
 * Method: BFS
 */
import java.util.*;
public class lc_317_shortestDistanceFromAllBuildings {
public static final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int shortestDistance(int[][] grid) {
        // validate input
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int row = grid.length, col = grid[0].length;
        int[][] visitedNum = new int[row][col];    // visited number cache
        int[][] distance = new int[row][col];   // distance cache
        int buildNum = 0;
        
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (grid[i][j] == 1){       // found one building
                    buildNum ++;
                    boolean[][] visited = new boolean[row][col];    // visited land cache
                    Queue<int[]> queue = new LinkedList<int[]>();   // empty land queue
                    queue.offer(new int[]{i,j});
                    int dist = 0;       // distance from each building
                    while (!queue.isEmpty()){
                        int currLand = queue.size();
                        for (int k = 0; k < currLand; k ++){
                            int[] land = queue.poll();
                            int x = land[0], y = land[1];
                            visitedNum[x][y] ++;
                            distance[x][y] += dist;
                            for (int[] dir : dirs){
                                int x2 = dir[0] + x, y2 = dir[1] + y;
                                if (x2 >= 0 && x2 < row && y2 >= 0 && y2 < col && !visited[x2][y2] && grid[x2][y2] == 0){
                                    queue.offer(new int[]{x2,y2});
                                    visited[x2][y2] = true;
                                }
                            }
                        }
                        dist ++;
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (grid[i][j] == 0 && visitedNum[i][j] == buildNum && distance[i][j] < result){
                    result = distance[i][j];
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
