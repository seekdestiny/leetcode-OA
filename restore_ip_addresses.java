/** 
 * algorithm is not hard, but handle corner case is hard
 * valid ip is 0 <= ip <= 255
 * "00" "01" is not valid only "0" is valid
 * 
**/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        helper(result, list, s, 0);
        return result;
    }
    
    private void helper(List<String> result, List<String> list, String s, int start) {
        if (list.size() == 4) {
            if (start != s.length()) return;
            
            StringBuilder sb = new StringBuilder();
            for (String tmp: list) {
                sb.append(tmp).append(".");
            }
            
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        
        for (int i = start; i < s.length() && i < start + 3; i++) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                list.add(tmp);
                helper(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        if (s.startsWith("0")) {
            return s.equals("0");
        }
        
        int digit = Integer.parseInt(s);
        return digit >= 0 && digit <= 255;
    }
}
