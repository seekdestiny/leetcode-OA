/** similar to ugly number ii
 * need 1 o(n) array to dp, 1 o(k) array to store track pointers.
 * O(n * k) time complexity
**/

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] times = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * ugly[times[j]]);
            }
            
            ugly[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * ugly[times[j]]) {
                    times[j]++;
                }
            }
        }
        
        return ugly[n - 1];
    }
}
