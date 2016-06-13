public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your 
        if (s == null || s.length() == 0) {
            return "";
        }
        
        s = s.trim();
        String[] sArray = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for (int i = sArray.length - 1; i >= 0; i--) {
            sb.append(sArray[i]).append(" ");
        }
        
        return sb.substring(0, sb.length() - 1);
    }
}
