package leetcode;
/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 * Method: use comparator to sort by starting time, and use priority queue to sort by ending time
 * get the size of priority queue in the end
 */
import java.util.*;
public class lc_253_meetingRooms2 {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, (a,b) -> a.end - b.end);
        for (int i = 0; i < intervals.length; i++){
            if (!pq.isEmpty() && intervals[i].start >= pq.peek().end){
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }
}
