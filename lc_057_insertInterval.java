package leetcode;
/* Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Method: three situations: (1) each.end < newInterval.start (2) newInterval.end < each.start (3) other
 * 
 */
import java.util.*;
public class lc_057_insertInterval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || newInterval == null){
            return result;
        }
        int insertPos = 0;
        for (Interval each : intervals){
            if (each.end < newInterval.start){
                result.add(each);
                insertPos ++;
            }else if (newInterval.end < each.start){
                result.add(each);
            }else{
                newInterval.start = Math.min(each.start, newInterval.start);
                newInterval.end = Math.max(each.end, newInterval.end);
            }
        }
        result.add(insertPos,newInterval);
        return result;
    }
}
