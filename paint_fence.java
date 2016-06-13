//Let's say we have 3 posts and 3 colors. The first two posts we have 9 ways to do them, (1,1), (1,2), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3). Now we know that
//diffColorCounts = 6;
//sameColorCounts = 3;
//Now for the third post, we can compute these two variables like this:
//If we use different colors than the last one (the second one), these ways can be added into diffColorCounts, so if the last one is 3, we can use 1 or 2, if it's 1, we can use 2 or 3, etc. Apparently there are (diffColorCounts + sameColorCounts) * (k-1) possible ways.+

//If we use the same color as the last one, we would trigger a violation in these three cases (1,1,1), (2,2,2) and (3,3,3). This is because they already used the same color for the last two posts. So is there a count that rules out these kind of cases? YES, the diffColorCounts. So in cases within diffColorCounts, we can use the same color as the last one without worrying about triggering the violation. And now as we append a same-color post to them, the former diffColorCounts becomes the current sameColorCounts.
//Then we can keep going until we reach the n. And finally just sum up these two variables as

public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        if (n == 0) return 0;
        if (n == 1) return k;
        
        int sameC = k;
        int diffC = k * (k - 1);
        
        for (int i = 2; i < n; i++) {
            int temp = diffC;
            diffC = (diffC + sameC) * (k - 1);
            sameC = temp;
        }
        
        return diffC + sameC;
    }
}
