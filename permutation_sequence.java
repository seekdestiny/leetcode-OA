/**
 * ith element is k / (n - i - 1)!
**/

class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        if (k <= 0) return sb.toString();
        
        int fac = 1;
        List<Integer> nums = new ArrayList<Integer>();
        
        for (int i = 1; i <= n; i++) {
            fac *= i;
            nums.add(i);
        }
        
        k--; // to make k / fac + 1 in same group
        for (int i = 0; i < n; i++) {
            fac /= n - i;
            int index = k / fac;
            sb.append(nums.get(index));
            nums.remove(index);
            k %= fac;
        }
        
        return sb.toString();
    }
}
