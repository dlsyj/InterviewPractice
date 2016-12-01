package leetcode;
/* Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n^2.
 *  Method:
 *  Here is the step of my solution:

(1)Build a minHeap of elements from the first row.
(2)Do the following operations k-1 times :
Every time when you poll out the root(Top Element in Heap), 
you need to know the row number and column number of that element(so we can create a tuple class here), 
replace that root with the next element from the same column.
 */
import java.util.*;
public class lc_378_KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int row = matrix.length, col = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < col; j ++){
            pq.offer(new Tuple(0,j,matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i ++){
            Tuple curr = pq.poll();
            if (curr.x == row - 1){
                continue;
            }
            pq.offer(new Tuple(curr.x + 1, curr.y, matrix[curr.x + 1][curr.y]));
            
        }
        return pq.peek().val;
    }
    
    public class Tuple implements Comparable<Tuple>{
        int x, y, val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple that){
            return this.val - that.val;
        }
    }
}
