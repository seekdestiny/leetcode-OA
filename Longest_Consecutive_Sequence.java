/**
 * similar to union find
 * for each number, 向下向上扩展直到断点，然后记录全局最大扩展量
 * 注意要remove 扩展过的数才能实现O(n)
 *
**/

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> record = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            record.add(nums[i]);
        }
        
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (record.contains(down)) {
                record.remove(down);
                down--;
            }
            
            int up = nums[i] + 1;
            while (record.contains(up)) {
                record.remove(up);
                up++;
            }
            
            longest = Math.max(longest, up - down - 1);
        }
        
        return longest;
    }
}
