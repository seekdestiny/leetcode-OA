//从Insert Interval那题的解法，我们知道了如何判断两个interval是否重合
//，如果不重合，如何判断先后顺序。那么这题就很简单了，首先按照start的大小来给所有interval排序，
//start小的在前。然后扫描逐个插入结果。如果发现当前interval a和结果中最后一个插入的interval b不重合，
//则插入a到b的后面；反之如果重合，则将a合并到b中。注意要给object排序需要定义一个compare structure作为sort函数的额外参数。

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;       
            }
        });
        
        List<Interval> result = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            if (last.end >= intervals.get(i).start) {
                last.end = Math.max(last.end, intervals.get(i).end);
            } else {
                result.add(last);
                last = intervals.get(i);
            }
        }
        
        result.add(last);
        return result;
    }
}
