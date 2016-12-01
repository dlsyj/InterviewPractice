package leetcode;
/* Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

https://leetcode.com/problems/android-unlock-patterns/

 * Method: DFS, with int[][] skip board
 */
public class lc_351_androidUnlockPatterns {
	public int numberOfPatterns(int m, int n) {
        // Skip array represents number to skip between two numbers
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[4][6] = skip[6][4] = 5;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[2][8] = skip[8][2] = 5;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
        boolean[] visited = new boolean[10];
        int result = 0;
        // DFS search each length from m to n
        for (int i = m; i <= n; i ++){
            result += DFS(visited, skip, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
            result += DFS(visited, skip, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
            result += DFS(visited, skip, 5, i - 1); // 5
        }
        return result;
    }
    
    public int DFS(boolean[] visited, int[][] skip, int curr, int remain){
        if (remain < 0){
            return 0;
        }
        if (remain == 0){
            return 1;
        }
        visited[curr] = true;
        int result = 0;
        for (int i = 1; i <= 9; i ++){
            // If vis[i] is not visited and (two numbers are adjacent or skip number is already visited)
            if (!visited[i] && (skip[curr][i] == 0 || visited[skip[curr][i]])){
                result += DFS(visited, skip, i, remain - 1);
            }
        }
        visited[curr] = false;
        return result;
    }
}
