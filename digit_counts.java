//当某一位的数字小于i时，那么该位出现i的次数为：更高位数字x当前位数
//当某一位的数字等于i时，那么该位出现i的次数为：更高位数字x当前位数+低位数字+1
//当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字+1)x当前位数
//When k == 0 and the current digit larger than k, the higher digits x digit position and it need to add one in the last result;

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int result = 0;
        int base = 1;
        
        while (base <= n) {
            int cur = (n / base) % 10;
            int low = n % base;
            int high = n / (base * 10);
            
            if (cur == k) {
                result += (high * base + low + 1);
            } else if (cur > k) {
                result += (high + (k == 0 ? 0 : 1)) * base;   
            } else {
                result += high * base;
            }
            
            base *= 10;
        }
        
        return result + (k == 0 ? 1 : 0);
    }
};
