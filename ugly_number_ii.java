/**
 * every new number is the product of one old number and 2 or 3 or 5.
 * use three pointers to record the last old number you used to multiply by related factor.
 * every step in iterative, get min of three new numbers.
 * if min == new number, then update related new number to a newer number
**/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        if (n <= 0) {
            return 0;
        }
        
        int f2 = 2;
        int f3 = 3;
        int f5 = 5;
        int id2 = 0;
        int id3 = 0;
        int id5 = 0;

        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(f2, f3), f5);
            res[i] = min;
            
            if (f2 == min) {
                f2 = 2 * res[++id2];
            }
            
            if (f3 == min) {
                f3 = 3 * res[++id3];
            }
            
            if (f5 == min) {
                f5 = 5 * res[++id5];
            }
        }
        
        return res[n - 1];
    }
};
