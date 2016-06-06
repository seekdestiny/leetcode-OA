//greedy
//一个比较好的算法是贪心算法（greedy）: whenever encounter ‘*’ in p, 
//keep record of the current position of ‘*’ in p and the current index in s. 
//Try to match the stuff behind this ‘*’ in p with s, if not matched, just s++ and then try to match again.

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null && p != null) return false;
        if (s != null && p == null) return false;
        
        int m = s.length();
        int n = p.length();
        
        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;
        
        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') { //record '*' position
                star = j;
                mark = i;
                j++;   //if not, next loop will enter this block again
            } else if (star != -1) {
                j = star + 1;
                i = ++mark;   //match the rest in s to * in p
            } else {
                return false;
            }
        }
        
        while (j < n && p.charAt(j) == '*') {
            j++;
        }
        
        return j == n;
     }
}

//dp
public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if (s == null && p != null) return false;
        if (s != null && p == null) return false;
        
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        for (int j = 1; j <= n; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j- 1];
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }  else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i - 1][j - 1];  
                }
            }
        }
        
        return dp[m][n];
     }
}
