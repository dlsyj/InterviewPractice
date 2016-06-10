public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return false;
    	}
    	int[] temp = new int[matrix.length*matrix[0].length];
    	int low = 0, high = temp.length;
    	while (low <= high){
    		int mid = low + (high - low)/2;
    		if (temp[mid] < target){
    			low = mid+1;
    		} else if (temp[mid] > target) {
    			high = mid-1;
    		} else {
    			return true;
    		}
    	}
    	return false;     
    }
}