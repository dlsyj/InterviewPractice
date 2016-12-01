package leetcode;
/* An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6
 * Method: binary search
 */
public class lc_302_smallestRectangleEnclosingBlackPixels {
	char[][] image;
    public int minArea1(char[][] image, int x, int y) {
        this.image = image;
        int m = image.length, n = image[0].length;
        int left = searchCol(0,y,0,m,true);         // first 1
        int right = searchCol(y + 1,n,0,m,false);   // first 0 after 1 
        int top = searchRow(0,x,left,right,true);   
        int bottom = searchRow(x+1,m,left,right,false);
        return (right - left)*(bottom - top);
    }
    
    // project columns on X-axis to find boundary of left and right
    private int searchCol(int i , int j, int top, int bottom, boolean increase){
        while (i != j){
            int k = top, mid = i+(j-i)/2;
            while (k < bottom && image[k][mid] == '0'){
                k ++;
            }
            if (k < bottom == increase){
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }
    
    private int searchRow(int i , int j, int left, int right, boolean increase){
        while (i != j){
            int k = left, mid = i+(j-i)/2;
            while (k < right && image[mid][k] == '0'){
                k ++;
            }
            if (k < right == increase){
                j = mid;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }
	
	// Brute force, 根本没用 x, y
	public int minArea(char[][] image, int x, int y) {
        if (image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int n = image.length;
        int m = image[0].length;
        int lengthX = 0;
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (image[i][j] != '0') {
                    lengthX++;
                    break;
                };
            }
        }
        int lengthY = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (image[i][j] != '0') {
                    lengthY++;
                    break;
                }
            }
        }
        return lengthX * lengthY;
    }
}
