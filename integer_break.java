/** 
 *把数尽量拆成2和3
 * O(n) dp solution
**/

public class Solution {
    public int integerBreak(int n) {
        if (n < 0) return 0;
        if (n <= 1) return 1;
        if (n <= 3) return n - 1;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
        }
        
        return dp[n];
    }
}

/** 
 *O(1) solution
 * n % 3 == 0:  那么全部拆成3
 * n % 3 == 1:  2个2剩下的为3    4*3^(x-1) > 1*3^x
 * n % 3 == 2:  1个2剩下的为3
**/

public class Solution {
    public int integerBreak(int n) {
        if (n < 0) return 0;
        if (n <= 1) return 1;
        if (n <= 3) return n - 1;
        
        int mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, n / 3);
        }
        
        if (mod == 1) {
            return (int) (4 * Math.pow(3, (n - 4) / 3));
        }
        
        return (int) (2 * Math.pow(3, n / 3));
    }
}
