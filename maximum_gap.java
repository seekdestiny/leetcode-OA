// be careful of bucket len and number of buckets
// bucket sort example

class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        // len for each bucket
        int len = (max - min) / n + 1;
        // number of buckets
        int k = (max - min) / len + 1;
        
        int[] localMin = new int[k];
        int[] localMax = new int[k];
        
        Arrays.fill(localMin, Integer.MAX_VALUE);
        Arrays.fill(localMax, Integer.MIN_VALUE);
        
        for (int i = 0; i < n; i++) {
            int t = (nums[i] - min) / len;
            localMin[t] = Math.min(localMin[t], nums[i]);
            localMax[t] = Math.max(localMax[t], nums[i]);
        }
        
        int maxGap = Integer.MIN_VALUE;
        int prev = 0;
        
        for (int i = 0; i < k; i++) {
            if (localMin[i] == Integer.MAX_VALUE && 
                localMax[i] == Integer.MIN_VALUE) {
                    continue;
            }
            
            maxGap = Math.max(maxGap, localMin[i] - localMax[prev]);
            prev = i;
        }
        
        return maxGap;
    }
}
