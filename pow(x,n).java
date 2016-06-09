public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        if (n == 0) return 1;
        boolean negative = false;
        if (n < 0) {
            n = -n;
            negative = true;
        }
        
        double res = myPow(x, n / 2);
        res *= res;
        
        if (n % 2 == 1) res *= x;
        if (negative) return 1 / res;
        return res;
    }
}
