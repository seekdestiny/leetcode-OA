/** sumary of permutation and combination
 * permutation 需要回头， 所以scan 所有数， 只跳过visited
 * combination 不能回头选， 所以需要passing scan 的起始点， i + 1, 可以省去boolean[] visited
 * 如果需要处理重复数，使用判断
            if (i > 0 && S.get(i - 1) == S.get(i) && !visited[i - 1]) {
                continue;
            }
**/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        helper(result, list, 1, n, k);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (!list.contains(i) && list.size() < k) {
                list.add(i);
                helper(result, list, i + 1, n, k);
                list.remove(list.size() - 1);
            }
        }
    }
}
