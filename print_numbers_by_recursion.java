// recursion depth must be at most N
// so result @ depth N is based on result @ depth N - 1

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 0) {
            return result;
        }
        
        helper(result, n);
        return result;
    }
    
    private void helper(List<Integer> result, int n) {
        if (n == 0) return;
        helper(result, n -1);
        int base = (int) Math.pow(10, n - 1);
        int size = result.size();
        for (int i = 1; i < 10; i++) {
            result.add(i * base);
            for (int j = 0; j < size; j++) {
                result.add(result.get(j) + i * base);
            }
        }
    }
}
