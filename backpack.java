public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        dp[0][0] = true;
        
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i + 1][j] = dp[i][j];
                
                if (j >= A[i] && dp[i][j - A[i]]) {
                    dp[i + 1][j] = true;
                }
            }
        }
        
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                return i;
            }
        }
        
        return 0;
    }
}
