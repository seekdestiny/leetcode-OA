/** voting algorithm
**/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
         
        if (nums == null || nums.length == 0) return res; 
        
        int res1 = 0;
        int res2 = 0;
        int c1 = 0;
        int c2 = 0;
        
        for (int num: nums) {
            if (res1 == num) {
                c1++;
            } else if (res2 == num) {
                c2++;
            } else if (c1 == 0) {
                res1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                res2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for (int num: nums) {
            if (res1 == num) c1++;
            else if (res2 == num) c2++;
        }
        
        if (c1 > nums.length / 3) res.add(res1);
        if (c2 > nums.length / 3) res.add(res2);
        
        return res;
    }
}
