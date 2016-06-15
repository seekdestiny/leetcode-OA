//two pointers

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = heights.length - 1;
        
        int area = 0;
        while (start < end) {
            if (heights[start] < heights[end]) {
                int smaller = heights[start];
                while (start < end && heights[start] <= smaller) {
                    area += smaller - heights[start];
                    start++;
                }
            } else {
                int smaller = heights[end];
                while (start < end && heights[end] <= smaller) {
                    area += smaller - heights[end];
                    end--;
                }
            }
        }
        
        return area;
    }
}
