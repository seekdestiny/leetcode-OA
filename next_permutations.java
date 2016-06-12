//1.从后往前寻找索引满足 a[k] < a[k + 1], 如果此条件不满足，则说明已遍历到最后一个。
//2.从后往前遍历，找到第一个比a[k]大的数a[l], 即a[k] < a[l].
//3.交换a[k]与a[l].
//4.反转k + 1 ~ n之间的元素。

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        //find the first nums[k] < nums[k + 1] from end to start
        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        
        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return nums;
        }
        
        //find the first nums[l] > nums[k] from end to start
        int l = nums.length - 1;
        while (nums[l] <= nums[k]) {
            l--;
        }
        
        //swap nums[l] and nums[k]
        int temp = nums[l];
        nums[l] = nums[k];
        nums[k] = temp;
        
        //reverse nums[k + 1] to end
        reverse(nums, k + 1, nums.length - 1);
        
        return nums;
    }
    
    private void reverse(int[] nums, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
