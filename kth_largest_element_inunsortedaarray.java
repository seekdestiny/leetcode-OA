//randomized selection quicksort

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        if (k <= 0 || k > nums.length) {
            return -1;
        }
        
        int i = 0;
        int j = nums.length - 1;
        while (true) {
            int pivot = partition(nums, i, j);
            if (pivot + 1 == k) {
                return nums[pivot];
            } else if (pivot + 1 > k) {
                j = pivot - 1;    
            } else {
                i = pivot + 1;
            }
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int rand = (int)(Math.random() * (end - start + 1)) + start;
        swap(nums, rand, end);
        int x = nums[end];
        int l = start;
        int r = end - 1;
        for (int i = start; i <= r; i++) {
            if (nums[i] > x) {
                swap(nums, i, l);
                l++;
            }
        }
        swap(nums, l, end);
        return l;
    }
    
    private void swap(int[] nums, int s1, int s2) {
        int temp = nums[s1];
        nums[s1] = nums[s2];
        nums[s2] = temp;
    }
}
