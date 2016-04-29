/**
 * first version is int version 
 * 九章模版
 * find last position at which mid * mid < x
**/
public Solution {
  public int mySqrt(int x) {
    if (x <= 0) return 0;
    int start = 1;
    int end = x;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (mid < x / mid) {
        start = mid;
      } else if (mid > x / mid) {
        end = mid;
      } else {
        return mid;
      }
    }
    
    if (end <= x / mid) {
      return end;
    } else {
      return start;
    }
  }
}
