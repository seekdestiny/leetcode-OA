/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // write your code here
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.end = Math.max(interval.end, newInterval.end);
                newInterval.start = Math.min(interval.start, newInterval.start);
            }
        }
        
        result.add(newInterval);
        return result;
    }
}
