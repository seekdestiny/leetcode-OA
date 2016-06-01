public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] cArray = s.toCharArray();
        
        int[] dp = new int[cArray.length + 1];
        
        dp[0] = 1;
        
        if (cArray[0] != '0') {
            dp[1] = 1;
        } else {
            return 0;
        }
        
        for (int i = 2; i <= cArray.length; i++) {
            if (cArray[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            
            int digit = (cArray[i - 2] - '0') * 10 + cArray[i - 1] - '0';
            
            if (digit >= 10 && digit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[cArray.length];
    }
}
