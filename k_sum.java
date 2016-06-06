//needs 3d array
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length;
        
        int[][][] dp = new int[n + 1][k + 1][target + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 1;
        }
        
        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= k && i <= m; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j >= A[m - 1]) {
                        dp[m][i][j] = dp[m - 1][i - 1][j - A[m - 1]];
                    }
                    dp[m][i][j] += dp[m - 1][i][j];
                }
            }
        }
        
        return dp[n][k][target];
    }
}
