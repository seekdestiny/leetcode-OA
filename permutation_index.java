*   If we treat our 4-element set as a positional system, then we get the
 *   following positional weights: 3!, 2!, 1!, 0. So that the index of
 *   {2, 4, 3, 1} is: x*3!+y*2!+z*1!+w*0. Presently it suffices to find the
 *   values of x,y,z to calculate the index (we ignore w because it is paired
 *   with 0). x,y,z are counters: the number of succeeding elements less than
 *   the element being considered. For example, in {2, 4, 3, 1}, there are
 *   two succeeding elements less than 4 (namely 3 and 1). For 2 it's 1 (1);
 *   for 4 it's 2 (3 and 1); for 3 it's 1 (1); for 1 it's 0.
 *
 *   Now we can calculate the index of {2, 4, 3, 1} as: x=1, y=2, z=1:
 *   x*3!+y*2!+z*1!+w*0 = 1*3! + 2*2! + 1*1! = 6 + 4 + 1 = 11.
 
 public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        long res = 0;
        long position = 2;
        long factor = 1;
        
        for (int i = A.length - 2; i >= 0; i--) {
            int min = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    min++;
                }
            }
            
            res += min * factor;
            factor *= position;
            position++;
        }
        
        return res + 1;
    }
}
