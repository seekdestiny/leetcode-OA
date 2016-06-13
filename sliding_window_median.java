//similar to data stream median. without hashheap, it can not be O(nlogn)

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap; 
     
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length < k) {
            return result;
        }
        
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        }); 
        
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }
        
        result.add(maxHeap.peek());
        
        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
            remove(nums[i - k]);
            result.add(maxHeap.peek());
        }
        
        return result;
    }
    
    private void add(int val) {
        if (maxHeap.isEmpty()) {
        	maxHeap.offer(val);
        	return;
        }
        if (val > maxHeap.peek()) {
            minHeap.offer(val);
        } else {
            maxHeap.offer(val);
        }
        balance();
    }
    
    private void remove(int val) {
        if (val > maxHeap.peek()) {
            minHeap.remove(val);
        } else {
            maxHeap.remove(val);
        }
        balance();
    }
    
    private void balance() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());    
        }
    }
}

/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        int pos = 0;
        if (n == 0)
            return result;
        int[] tmp = new int[k];
        for (int i = 0; i < k; ++i)
            tmp[i] = nums[i];

        Arrays.sort(tmp); 
        for (int i = k ; i < n; ++i) {
            result.add(tmp[(k-1) / 2]);
            for (int j = 0; j < k; ++j)
                if (tmp[j] == nums[i-k]) {
                    tmp[j] = nums[i];
                    pos = j;
                    break;
                }
            while (pos > 0 && tmp[pos] < tmp[pos - 1]) {
                int t = tmp[pos]; tmp[pos] = tmp[pos-1]; tmp[pos-1] = t;  
                pos -= 1;
            }
            while (pos + 1 < k && tmp[pos] > tmp[pos + 1]) {
                int t = tmp[pos]; tmp[pos] = tmp[pos+1]; tmp[pos+1] = t;  
                pos += 1;
            }

        }
        result.add(tmp[(k-1) / 2]);
        return result;
    }
}
