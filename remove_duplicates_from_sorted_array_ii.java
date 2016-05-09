/** add a local to track how many duplicate number has been added for current value
**/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int size = 0;
        int local = 0;
        int prev = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) {
                if (local < 2) {
                    local++;
                    nums[size] = nums[i];
                    size++;
                }
            } else {
                local = 1;
                nums[size] = nums[i];
                size++;
                prev = nums[i];
            }
        }
        
        return size;
    }
}
