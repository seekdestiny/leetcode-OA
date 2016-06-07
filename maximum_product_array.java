public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int preMax = max;
            int preMin = min;
            max = min = nums[i];
            if (nums[i] > 0) {
                max = Math.max(max, preMax * nums[i]);
                min = Math.min(min, preMin * nums[i]);
            } else if (nums[i] < 0) {
                max = Math.max(max, preMin * nums[i]);
                min = Math.min(min, preMax * nums[i]);
            }
            
            result = Math.max(result, max);
        }
        
        return result;
    }
}
