/**
 * 这题概念上很简单，有几种方法可以做。比如将每个[i, j]对应旋转对称的四个点的坐标算出来，然后pixel by pixel的旋转。
 * 但个人感觉这种计算面试中比较容易出错。
 * 想了看了几种方法后，觉得“剥洋葱”法一层一层地旋转最容易理解和写对。注意这里offset的使用以及中止条件start<end。
 **/

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int n = matrix.length;
        int level = n / 2;
        for (int i = 0; i < level; i++) {
            int last = n - 1 - i;
            for (int j = i; j < last; j++) {
                int offset = j - i;
                int temp = matrix[i][j];    
                matrix[i][j] = matrix[last - offset][i];
                matrix[last - offset][i] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[j][last];
                matrix[j][last] = temp;
            }
        }
    }
}
