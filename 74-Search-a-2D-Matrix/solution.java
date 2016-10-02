public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col;
        while (left < right){
            int mid = left + (right - left)/2;
            int midVal = matrix[mid/col][mid%col];
            if (midVal == target){
                return true;
            } else if (midVal < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}