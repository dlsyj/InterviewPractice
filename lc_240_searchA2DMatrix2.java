package leetcode;
/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

 * Method: The check always starts at the end of the row. If target is smaller than the last element of the row, that means it might be in such row. 
 * If target is larger, proceed to the next row.
Hence worst case scenario is O(m+n).
Such as to search 18 in the above matrix, when you are searching 18, you should see 15, 19, 12, 17. 26, 23, 21, 18.
 */
public class lc_240_searchA2DMatrix2 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] < target){
                row ++;
            }else if (matrix[row][col] > target){
                col --;
            }else{
                return true;
            }
        }
        return false;
    }
	// Time O(m+n)
}
