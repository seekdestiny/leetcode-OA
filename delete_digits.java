//k rounds scan
//every round delete the first number which is larger than the successor
//O(k * n)

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A.length() == k) {
            return "";
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < A.length(); j++) {
                if (j == A.length() - 1 || A.charAt(j) > A.charAt(j + 1)) {
                    A = A.substring(0, j) + A.substring(j + 1, A.length());
                    break;
                }
            }
        }
        
        int i = 0;
        while (i < A.length() && A.charAt(i) == '0') {
            i++;
        }
        
        return A.substring(i, A.length());
    }
}

//increasing stack
//O(n) 

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A.length() < k) return "";
        
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        for (int i = 0; i < A.length(); i++) {
            while (sb.length() != 0 && 
                   sb.charAt(sb.length() - 1) > A.charAt(i) && 
                   cnt < k) {
                sb.deleteCharAt(sb.length() - 1);
                cnt++;
            }
            
            if (A.charAt(i) != '0' || sb.length() != 0) {
                sb.append(A.charAt(i));
            }
        }
        
        while (cnt < k) {
            sb.deleteCharAt(sb.length() - 1);
            cnt++;
        }
        
        return sb.toString();
    }
}
