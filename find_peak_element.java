/** 九章模版
 *find the first position at which descending
**/

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 2] < nums[nums.length - 1]) return (nums.length - 1);
        
        int start = 1;
        int end = nums.length - 2;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] < nums[mid]) {
                start =  mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }
}
