/** make a function to determine whether it is palindrome
**/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();
        
        if (s == null || s.length() == 0) {
            return res;
        }
        
        List<String> list = new ArrayList<String>();
        helper(res, list, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> list,
                 String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }          
        
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPan(sub)) {
                list.add(sub);
                helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPan(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
}
