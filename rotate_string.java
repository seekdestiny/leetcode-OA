//need to use gcd

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            return;
        }
        
        int length = str.length;
        offset = offset % length;
        
        int gcd = findGCD(length, offset);
        
        for (int i = 0; i < gcd; i++) {
            char prev = str[i];
            int current = i;
            
            while (true) {
                int target = (current - offset + length) % length;
                if (target == i) {
                    str[current] = prev;
                    break;
                }
                
                str[current] = str[target];
                current = target;
            }
        }
    }
    
    private int findGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        
        return findGCD(num2, num1 % num2);
    }
}
