/** similar to bucket sort
 * 这道题类似桶排序问题，
 * 如果不能用额外的空间的话，那么其实只需要从0开始遍历到n-1,
 * 每次当A[i]!= i的时候，将A[i]与A[A[i]]交换，大于边界的话，丢掉就可以了，
 * 直到无法交换位置。 如果有发现 A[i]始终不等于A[A[i]]。那么i就是first missing number
**/

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i && nums[i] < n) {
                int t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        
        return n;
    }
}
