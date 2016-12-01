package leetcode;
// Method: 
import java.util.*;
public class lc_218_skylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
        // using priority queue
        List<int[]> result = new ArrayList<int[]>();
        List<int[]> height = new ArrayList<int[]>();
        for (int[] each : buildings){
            height.add(new int[]{each[0],each[2]}); // add starting point
            height.add(new int[]{each[1],-each[2]});// add ending point
        }
        Collections.sort(height,(a,b) -> {
            if (a[0] != b[0]){
                return a[0] - b[0]; // firstly sort by starting point(ascending)
            }else{
                return b[1] - a[1]; // if same, then sort by ending point(descending)
            }
        });
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));// max heap
        pq.offer(0);
        int prev = 0;
        for (int[] each : height){
            if (each[1] > 0){
                pq.offer(each[1]);  // if get starting point, offer height
            }else{
                pq.remove(-each[1]);    // if get ending point, remove height
            }
            int curr = pq.peek();
            if (prev != curr){
                result.add(new int[]{each[0],curr});
                prev = curr;
            }
        }
        return result;
    }
}
