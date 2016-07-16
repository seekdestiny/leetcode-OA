//Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

//Each element is either an integer, or a list -- whose elements may also be integers or other lists.

//Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        List<Integer> sum = new ArrayList<Integer>();
        getSum(sum, nestedList, 0);
        
        int res = 0;
        for (int i = 0; i < sum.size(); i++) {
            res += sum.get(i) * (sum.size() - i);
        }
        
        return res;
    }
    
    private void getSum(List<Integer> sum, List<NestedInteger> nestedList, int depth) {
        if (sum.size() == depth) {
            sum.add(0);
        }
        
        for (NestedInteger cur : nestedList) {
            if (cur.isInteger()) {
                sum.set(depth, sum.get(depth) + cur.getInteger());
            } else {
                getSum(sum, cur.getList(), depth + 1);
            }
        }
    }
}
