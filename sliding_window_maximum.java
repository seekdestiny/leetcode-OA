//我们用双向队列可以在O(N)时间内解决这题。
//当我们遇到新的数时，将新的数和双向队列的末尾比较，
//如果末尾比新数小，则把末尾扔掉，直到该队列的末尾比新数大或者队列为空的时候才住手。
//这样，我们可以保证队列里的元素是从头到尾降序的，由于队列里只有窗口内的数，
//所以他们其实就是窗口内第一大，第二大，第三大...的数。保持队列里只有窗口内数的方法和上个解法一样，
//也是每来一个新的把窗口最左边的扔掉，然后把新的加进去。然而由于我们在加新数的时候，
//已经把很多没用的数给扔了，这样队列头部的数并不一定是窗口最左边的数。
//这里的技巧是，我们队列中存的是那个数在原数组中的下标，这样我们既可以直到这个数的值，
//也可以知道该数是不是窗口最左边的数。这里为什么时间复杂度是O(N)呢？因为每个数只可能被操作最多两次，
//一次是加入队列的时候，一次是因为有别的更大数在后面，所以被扔掉，或者因为出了窗口而被扔掉。

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length < k || k <= 0) {
            return result;
        }
        
        LinkedList<Integer> deque = new LinkedList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            
            deque.offerLast(i);
            
            if ((i + 1) >= k) {
                result.add(nums[deque.peek()]);
            }
        }
        
        return result;
    }
}
