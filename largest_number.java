// pay attention to comparator define

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        String str[] = new String[num.length];
        
        for (int i = 0; i < num.length; i++) {
            str[i] = String.valueOf(num[i]);
        }
        
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        String res = "";
        boolean allZero = true;
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("0")) allZero = false;
            res += str[i];
        }
        
        if (allZero) return "0";
        return res;
    }
}
