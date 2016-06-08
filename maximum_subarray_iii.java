// Time:  O(k * n^2)
// Space: O(k * n)

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k) {
            return 0;
        }
        
        int n = nums.length;

        int[][] dp = new int[n + 1][k + 1];
        
        for (int j = 1; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                dp[i][j] = Integer.MIN_VALUE;
                
                int endMax = 0;
                int max = Integer.MIN_VALUE;
                
                for (int m = i - 1; m >= j - 1; m--) {
                    endMax = Math.max(nums[m], endMax + nums[m]);
                    max = Math.max(endMax, max);
                    dp[i][j] = Math.max(dp[i][j], dp[m][j - 1] + max);
                }
            }
        }
        
        return dp[n][k];
    }
}
