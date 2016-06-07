//max means when nums[i] is multiplied what is the local max product?
//min means when nums[i] is multiplied what is the local min product?

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
        
            if (nums[i] > 0) {
                max = Math.max(nums[i], preMax * nums[i]);
                min = Math.min(nums[i], preMin * nums[i]);
            } else if (nums[i] < 0) {
                max = Math.max(nums[i], preMin * nums[i]);
                min = Math.min(nums[i], preMax * nums[i]);
            } else {
                max = min = nums[i];
            }
            
            result = Math.max(result, max);
        }
        
        return result;
    }
}
