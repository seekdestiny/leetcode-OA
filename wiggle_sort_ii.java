//time O(n), space O(1) need to build a map function

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int median = getMedian(nums);
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i <= end) {
            if (nums[reIndex(i, nums.length)] == median) {
                i++;
            } else if (nums[reIndex(i, nums.length)] < median) {
                swap(nums, reIndex(i, nums.length),
                           reIndex(end--, nums.length));
            } else {
                swap(nums, reIndex(i++, nums.length), 
                           reIndex(start++, nums.length));
            }
        }
    }
    
    private int reIndex(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }
    
    private int getMedian(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int k = (nums.length + 1) / 2;
        
        while (true) {
            int pivot = partition(nums, start, end);   
            if (pivot + 1 > k) {
                end = pivot - 1;
            } else if (pivot + 1 < k) {
                start = pivot + 1;
            } else {
                return nums[pivot];
            }
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        swap(nums, mid, end);
        int l = start;
        int r = end - 1;
        int i = l;
        while (i <= r) {
            if (nums[i] < nums[end]) {
                swap(nums, i, l);
                l++;
            }
            i++;
        }
        
        swap(nums, l, end);
        return l;
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

//time O(n), space O(n)

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int median = getMedian(nums);
        int start = 0;
        int end = nums.length - 1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < median) {
                temp[start++] = nums[i];
            } else if (nums[i] > median) {
                temp[end--] = nums[i];
            }
        }
        
        int mid_index = (nums.length + 1) / 2;
        while (start < mid_index) temp[start++] = median;
        while (end >= mid_index) temp[end--] = median;
        
        end = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? temp[--start] : temp[--end];
        }
    }
    
    private int getMedian(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int k = (nums.length + 1) / 2;
        
        while (true) {
            int pivot = partition(nums, start, end);   
            if (pivot + 1 > k) {
                end = pivot - 1;
            } else if (pivot + 1 < k) {
                start = pivot + 1;
            } else {
                return nums[pivot];
            }
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        swap(nums, mid, end);
        int l = start;
        int r = end - 1;
        int i = l;
        while (i <= r) {
            if (nums[i] < nums[end]) {
                swap(nums, i, l);
                l++;
            }
            i++;
        }
        
        swap(nums, l, end);
        return l;
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

//O(nlogn) space O(n)
//sort then rearrane 
public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        Arrays.sort(nums);
        int mid = (nums.length + 1) / 2 - 1;
        int end = nums.length - 1;
        
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = i % 2 == 0 ? nums[mid--] : nums[end--];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
