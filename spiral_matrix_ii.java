/** 
* II比I简单，一样的按层访问法。由于是正方形矩阵
* 当n为奇数时，最后只会剩下一个数字即matrix[n/2][n/2]，最后不要忘记补填上这个数字。
**/
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        
        int[][] res = new int[n][n];
        
        int level = (n + 1) / 2;
        
        int num = 1;
        
        for (int i = 0; i < level; i++) {
            int last = n - 1 - i;
            
            if (last < i) {
                break;
            } else if (last == i) {
                res[i][i] = num;
            } else {
                for (int j = i; j < last; j++) {
                    res[i][j] = num;
                    num++;
                }
                for (int j = i; j < last; j++) {
                    res[j][last] = num;
                    num++;
                }
                for (int j = last; j > i; j--) {
                    res[last][j] = num;
                    num++;
                }
                for (int j = last; j > i; j--) {
                    res[j][i] = num;
                    num++;
                }
            }
        }
        
        return res;
    }
}
