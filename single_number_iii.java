/** bit manipulation
 * x & (x - 1) change the last bit one to zero
 * x - (x & (x - 1)) will get only last bit one
 * based on last bit one to separate array
**/

public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        
        int lastBitOne = xor - (xor & (xor - 1));
        
        int group0 = 0; int group1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((lastBitOne & nums[i]) == 0) {
                group0 ^= nums[i];
            } else {
                group1 ^= nums[i];
            }
        }
        
        int[] res = new int[]{group0, group1};
        
        return res;
    }
}
