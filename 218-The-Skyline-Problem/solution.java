public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // using priority queue
        List<int[]> result = new ArrayList<int[]>();
        List<int[]> height = new ArrayList<int[]>();
        for (int[] each : buildings){
            height.add(new int[]{each[0],each[2]});
            height.add(new int[]{each[1],-each[2]});
        }
        Collections.sort(height,(a,b) -> {
            if (a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return b[1] - a[1];
            }
        });
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (int[] each : height){
            if (each[1] > 0){
                pq.offer(each[1]);
            }else{
                pq.remove(-each[1]);
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