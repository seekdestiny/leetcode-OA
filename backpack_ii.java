//dp[i][j] means max value with first i items and weight j

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int n = A.length;
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m; j++) {
                if (A[i] > j) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - A[i]] + V[i]);
                }
            }
        }
        
        return dp[n][m];
    }
}
