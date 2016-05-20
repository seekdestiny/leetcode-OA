/** out-degree and in-degree
 ** because preorder, diff >= 0
 ** at last, diff must be 0
**/

public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        
        int diff = 1;
        String[] array = preorder.split(",");
        
        for (String tmp : array) {
            if (--diff < 0) return false;
            if (!tmp.equals("#")) diff += 2;
        }
        
        return diff == 0;
    }
}
