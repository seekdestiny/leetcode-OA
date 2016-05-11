/** bit manipulation
**/

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] bit = new int[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                if (((num>>(31-i)) & 1) == 1) bit[i]++; 
            }
            
            if (bit[i] % 3 == 1) {
                res += 1<<(31-i);
            }
        }
        
        return res;
    }
}
