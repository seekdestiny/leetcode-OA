// constant space implementation
// construct two arrays [1, a0, a0a1, a0a1a2] [a1a2a3, a2a3, a3,1]

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length];
        int len = nums.length;
        
        int p = 1;
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            p *= nums[i - 1];
            result[i] = p;
        }
        
        p = 1;
        for (int i = len - 2; i >= 0; i--) {
            p *= nums[i + 1];
            result[i] *= p;
        }
        
        return result;
    }
}
