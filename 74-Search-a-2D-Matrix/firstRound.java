public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return false;
    	}
    	int[] temp = new int[matrix.length*matrix[0].length];
    	int num = 0;
    	for (int i = 0; i < matrix.length; i++){
    		for (int j = 0; j < matrix[0].length; j++){
    			temp[num++] = matrix[i][j];
    		}
    	}
    	int low = 0, high = temp.length;
    	while (low < high){
    		int mid = low + (high - low)/2;
    		if (temp[mid] < target){
    			low = mid;
    		} else if (temp[mid] > target) {
    			high = mid;
    		} else {
    			return true;
    		}
    	}
    	return false;     
    }
}