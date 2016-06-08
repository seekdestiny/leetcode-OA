// time complexity o(n)
// see analysis here : https://www.youtube.com/watch?v=d3qd_wQdYqg

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        
        for (int k = A.length / 2; k >= 0; k--) {
            siftdown(A, k);
        }
    }
    
    private void siftdown(int[] A, int k) {
        while (k < A.length) {
            int temp = k;
            if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[temp]) {
                temp = k * 2 + 1;
            }
            
            if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[temp]) {
                temp = k * 2 + 2;
            }
            
            if (temp == k) {
                break;
            }
            
            int swap = A[temp];
            A[temp] = A[k];
            A[k] = swap;
            
            k = temp;
        }
    }
}
