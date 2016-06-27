public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        long res = 0;
        long position = 1;
        long factor = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        long dup = 1;
        
        for (int i = A.length - 1; i >= 0; i--) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
                dup *= map.get(A[i]);
            }
            
            int min = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    min++;
                }
            }
            
            res += min * factor / dup;
            factor *= position;
            position++;
        }
        
        return res + 1;
    }
}
