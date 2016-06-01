//dp[i][j] means min adjustment cost for first i items in A with last position is j (1 <= j <= 100)

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int n = A.size();
        int[][] dp = new int[n + 1][101];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k <= 100; k++) {
                       if (Math.abs(j - k) <= target) {
                           dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - A.get(i - 1)));
                       }
                    }
                } 
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        
        return ans;
    }
}
