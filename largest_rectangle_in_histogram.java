/** using increasing stack
 ** when some item pop out, the one before it is the first one smaller than it on the left
 ** the new will be pushed, the first one smaller that it on the right
**/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            
            stack.push(i);
        }
        
        return max;
    }
}
