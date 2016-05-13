/** maintain four states
 * first select current select, first select current not select,
 * first not select current select, first not select current not select
 * finally compare first select current not select and first not select current select
**/

public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) return nums[0];
        
        //if first house not selected
        int nFirstnCurrent = 0;
        int nFirstCurrent = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = nFirstnCurrent;
            nFirstnCurrent = Math.max(nFirstnCurrent, nFirstCurrent);
            nFirstCurrent = temp + nums[i];
        }
        
        //if first house selected
        int FirstnCurrent = 0;
        int FirstCurrent = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = FirstnCurrent;
            FirstnCurrent = Math.max(FirstnCurrent, FirstCurrent);
            FirstCurrent = temp + nums[i];
        }
        
        return Math.max(nFirstCurrent, FirstnCurrent);
    }
}
