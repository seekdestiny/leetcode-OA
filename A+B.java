class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int res = 0;
        
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int da = (a >> i) & 1;
            int db = (b >> i) & 1;
            
            int sum = 0;
            if ((da & db) == 1) {
                sum = carry << i;
                carry = 1;
            } else if ((da | db) == 1) {
                if (carry == 1) {
                    sum = 0 << i;
                } else {
                    sum = 1 << i;
                }
            } else {
                sum = carry << i;
                carry = 0;
            }
            
            res |= sum;
        }
        
        return res;
    }
};

// 主要利用异或运算来完成 
// 异或运算有一个别名叫做：不进位加法
// 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
// 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
// a & b就是a和b里都是1的那些位置，a & b << 1 就是进位
// 之后的结果。所以：a + b = (a ^ b) + (a & b << 1)
// 令a' = a ^ b, b' = (a & b) << 1
// 可以知道，这个过程是在模拟加法的运算过程，进位不可能
//一直持续，所以b最终会变为0。因此重复做上述操作就可以
// 求得a + b的值。
        
class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        
        return a;
    }
};
