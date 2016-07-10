/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Point implements Comparable<Point> {
    public int time;
    public int flag;
    
    public Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
    
    public int compareTo(Point p2) {
        if (time == p2.time) {
            return flag - p2.flag;
        }   
        
        return time - p2.time;
    }
}


class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        
        if (airplanes.size() == 1) {
            return 1;
        }
        
        List<Point> list = new ArrayList<Point>(airplanes.size() * 2);
        for (Interval interval: airplanes) {
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, 0));
        }
        
        Collections.sort(list);
        
        int count = 0;
        int maxAir = 0;
        for (Point p : list) {
            if (p.flag == 1) count++;
            else count--;
            maxAir = Math.max(maxAir, count);
        }
        
        return maxAir;
    }
}
