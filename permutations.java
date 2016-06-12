/**
 * backtracing template use
 * 见九章模版
**/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(nums);
        helper(res, list, nums, 0);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, 
    ArrayList<Integer> list, ArrayList<Integer> nums, int start) {
        if (list.size() == nums.size()) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            int number = nums.get(i);
            if (!list.contains(number)) {
                list.add(number);
                helper(res, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}

//non-recursive
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        
        Collections.sort(nums);
        
        while (true) {
            res.add(new ArrayList<Integer>(nums));
            
            int k = -1;
            for (int i = nums.size() - 2; i >= 0; i--) {
                if (nums.get(i) < nums.get(i + 1)) {
                    k = i;
                    break;
                }
            }
            
            if (k == -1) break;
            
            int l = nums.size() - 1;
            while (nums.get(l) <= nums.get(k)) {
                l--;
            }
            
            int temp = nums.get(l);
            nums.set(l, nums.get(k));
            nums.set(k, temp);
            reverse(nums, k + 1, nums.size() - 1);
        }
        
        return res;
    }    
    
    private void reverse(ArrayList<Integer> nums, int start, int end) {
        int l = start;
        int r = end;
        while (l < r) {
            int temp = nums.get(l);
            nums.set(l, nums.get(r));
            nums.set(r, temp);
            l++;
            r--;
        }
    }
}


