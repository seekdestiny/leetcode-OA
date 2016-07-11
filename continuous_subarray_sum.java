//need to return index
//remember the start index should be presum index + 1
//minIndex start from -1

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (A == null || A.length == 0) {
            return result;
        }
        
        int max = Integer.MIN_VALUE;
        int minSum = 0;
        int minIndex = -1;
        int sum = 0;
        int[] res = new int[2];
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum - minSum > max) {
                max = sum - minSum;
                res[0] = minIndex + 1;
                res[1] = i;
            }
            
            if (sum < minSum) {
                minSum = sum;
                minIndex = i;
            }
        }
        
        result.add(res[0]);
        result.add(res[1]);
        
        return result;
    }
}
