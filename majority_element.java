/** “投票算法”，设定两个变量candidate和count。candidate保存当前可能的候选众数，count保存该候选众数的出现次数。
*    遍历数组num。
*   如果当前的数字e与候选众数candidate相同，则将计数count + 1
*   否则，如果当前的候选众数candidate为空，或者count为0，则将候选众数candidate的值置为e，并将计数count置为1。
*   否则，将计数count - 1
*   最终留下的候选众数candidate即为最终答案。
*   以上算法时间复杂度为O(n)，空间复杂度为O(1)
**/

public class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            
            if (res == num) count++;
            else count--;
        }
        
        return res;
    }
}

/** 时间复杂度: O(n) — 位操作法: 我们需要32次迭代,
 *   每一次计算所有n个数的第i位的1的个数。由于众数一定存在，那么或者1的个数 > 0的个数 或者反过来(但绝不会相同)。 
 *   众数的第i位一定是计数较多数字。
 **/
 public int majorityElement(int[] nums) {  
    int[] bit = new int[32];  
    for (int num: nums)  
        for (int i=0; i<32; i++)   
            if ((num>>(31-i) & 1) == 1)  
                bit[i]++;  
    int ret=0;  
    for (int i=0; i<32; i++) {  
        bit[i]=bit[i]>nums.length/2?1:0;  
        ret += bit[i]*(1<<(31-i));  
    }  
    return ret;  
}  
