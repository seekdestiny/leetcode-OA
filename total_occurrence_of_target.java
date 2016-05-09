/** 用两次二分
 *找first position and last position
**/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int first = 0;
        int second = 0;
        
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] == target) {
            first = start;
        } else if (A[end] == target) {
            first = end;
        } else {
            return 0;
        }
        
        start = 0;
        end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (A[end] == target) {
            second = end;
        } else if (A[start] == target) {
            second = start;
        } else {
            return 0;
        }
        
        return (second - first + 1);
    }
}
