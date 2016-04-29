/**
 * first version is int version 
 * 九章模版
 * find last position at which mid * mid < x
**/
public Solution {
  public int mySqrt(int x) {
    if (x <= 0) return 0;
    int start = 0;
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

/**
 * second version is double version 
 * end - start > tolerance
 * x less thant 1 then end pointer starts from 1
**/
public Solution{
  public double mySqrt(double x) {
      if (x <= 0) return 0;
      double lo = 0;
      double high = x < 1 ? 1 : x;
      double tolerance = 1e-9;
      while (lo <= high && (high - lo) > tolerance) {
          int mid = lo + (high - lo) / 2;
          if (mid < x / mid) {
            lo = mid;
          } else if (mid > x / mid) {
            high = mid;
          } else {
            return mid;
          }
      }
      
      return lo + (high - lo) / 2;
  }
}

