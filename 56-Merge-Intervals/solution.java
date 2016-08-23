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
        List<Interval> result = new ArrayList<Interval>();
        int len = intervals.size();
        
        // Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.start,i2.start);
            }
        });
        
        int currentStart = intervals.get(0).start;
        int currentEnd = intervals.get(0).end;
        for (Interval each: intervals){
            if (each.start < currentEnd){  // Overlapping intervals
                currentEnd = Math.max(currentEnd,each.end);
            } else {                       // Disjoint intervals
                result.add(new Interval(currentStart,currentEnd));
                currentStart = each.start;
                currentEnd = each.end;
            }
        }
        result.add(new Interval(currentStart,currentEnd));
        return result;
    }
}