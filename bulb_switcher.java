/** 只有完全平方数才有奇数个因子， 才会最后亮灯
 * 数有多少个完全平方数小于n
**/

public class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        
        return count;
    }
}
