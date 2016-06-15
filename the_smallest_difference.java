//chase-type two pointers

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return 0;
        }
        
        if (A == null || A.length == 0) {
            Arrays.sort(B);
            return B[0];
        }
        
        if (B == null || B.length == 0) {
            Arrays.sort(A);
            return A[0];
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int ida = 0;
        int idb = 0;
        
        int min = Integer.MAX_VALUE;
        
        while (ida < A.length || idb < B.length) {
            min = Math.min(min, Math.abs(A[Math.min(ida, A.length - 1)] 
                                       - B[Math.min(idb, B.length - 1)]));
            
            if (ida < A.length && idb < B.length) {
                if (A[ida] < B[idb]) ida++;
                else if (A[ida] > B[idb]) idb++;
                else return 0;
            } else if (ida < A.length) {
                ida++;
            } else if (idb < B.length) {
                idb++;
            }
        }
        
        return min;
    }
}
