/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        int len = intervals.size();
        int[] startArray = new int[len];
        int[] endArray = new int[len];
        for (int i = 0; i < len; i++){
            startArray[i] = intervals.get(i).start;
            endArray[i] = intervals.get(i).end;
        }
        // Sort start & end
        Arrays.sort(startArray);
        Arrays.sort(endArray);
        // Iterate and merge
        for (int i = 0, j = 0; i < len; i++){
            if (i == len -1 || startArray[i+1] > endArray[i]){
                ans.add(Interval(startArray[i],endArray[i]));
                j = i+1;
            }
        }
        return ans;
    }
}