//定义dp[i]表示从i到end能取到的最大值

//当我们在i处，有两种选择：

//1.若取values[i]，对方可以取values[i+1] 或者values[i+1] + values[i+2]

//当对方取values[i+1] 后 ，我们只能从 i+2 到end内取，我们所取得最大值是dp[i+2],  注意：对方所选取的结果一定是使得我们以后选取的值最小

//当对方取values[i+1] + values[i+2]后，我们只能从i+3到end内取，我们所取得最大值是dp[i+3]。

//此时：dp[i] = values[i] + min(dp[i+2],dp[i+3]) , 注意：对方所选取的结果一定是使得我们以后选取的值最小

//2.若取values[i] + values[i+1],对方可取values[i+2] 或者values[i+2] + values[i+3]

//当对方取values[i+2]后，我们只能从i+3到end内取，我们取得最大值是dp[i+3]

//当对方取values[i+2]+values[i+3]后，我们只能从i+4到end内去，我们取得最大值是dp[i+4]

//此时：dp[i] = values[i] + values[i+1]+min(dp[i+3],dp[i+4])

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return true;
        }
        
        int len = values.length;
        
        if (len <= 2) {
            return true;
        }
        
        int[] dp = new int[len + 1];
        
        dp[len] = 0;
        dp[len - 1] = values[len - 1];
        dp[len - 2] = values[len - 2] + values[len - 1];
        dp[len - 3] = values[len - 3] + values[len - 2];
        
        for (int i = len - 4; i >= 0; i--) {
            dp[i] = values[i] + Math.min(dp[i + 2], dp[i + 3]);
            dp[i] = Math.max(dp[i], values[i] + values[i + 1] 
                                  + Math.min(dp[i + 3], dp[i + 4]));
        }
        
        int sum = 0;
        for (int coinValue: values) {
            sum += coinValue;
        }
        
        return dp[0] > sum - dp[0];
    }
} 
