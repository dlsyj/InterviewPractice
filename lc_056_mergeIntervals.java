package leetcode;
/* Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * 
 */
import java.util.*;
public class lc_056_mergeIntervals {
	public class Interval{
		int start;
		int end;
		public Interval() { start = 0; end = 0; }
		public Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
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
                result.add(new Interval(startArray[j],endArray[i]));
                j = i+1;
            }
        }
        return result;
    }
	// Time complexity O(nlogn + nlogn + n) = O(nlogn), Space: O(n)
}
