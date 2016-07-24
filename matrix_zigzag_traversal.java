public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int index = 0;
        int[] res = new int[(m + 1) * (n + 1)];
        
        for (int i = 0; i <= m + n; i++) {
            if (i % 2 == 0) {
                for (int x = Math.min(i, m); x >= Math.max(0, i - n); x--) {
                    res[index++] = matrix[x][i - x];
                }
            } else {
                for (int x = Math.max(0, i - n); x <= Math.min(i, m); x++) {
                    res[index++] = matrix[x][i - x];
                }
            }
        }
        
        return res;
    }
}
