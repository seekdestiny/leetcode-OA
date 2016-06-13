//need to track min 2 sub solution when calculated larger solution

public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int n = costs.length;
        int k = costs[0].length;
        
        int[][] dp = new int[n + 1][k];
        
        int m1 = 0;
        int m2 = 0;
        
        for (int i = 1; i <= n; i++) { 
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minColor1 = 0;
            int minColor2 = 0;
            
            for (int j = 0; j < k; j++) {
                if (j == m1) {
                    dp[i][j] = dp[i - 1][m2] + costs[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][m1] + costs[i - 1][j];
                }
                
                if (dp[i][j] <= min1) {
                    min2 = min1;
                    minColor2 = minColor1;
                    min1 = dp[i][j];
                    minColor1 = j;
                } else if (dp[i][j] > min1 && dp[i][j] < min2) {
                    min2 = dp[i][j];
                    minColor2 = j;
                }
            }
            
            m1 = minColor1;
            m2 = minColor2;
        }
        
        return dp[n][m1];
    }
}
