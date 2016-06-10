// many corner cases

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if (n.indexOf(".") == -1) {
            return parseInteger(n);
        }
    
        String[] param = n.split("\\.");
        String flt = parseFloat(param[1]);
    
        if (flt.equals("ERROR")) return flt;
        if (flt.equals("") || flt.equals("0")) {
            return parseInteger(param[0]);
        }
    
        return parseInteger(param[0]) + "." + flt;
    }
    
    private String parseInteger(String str) {
        int n = Integer.parseInt(str);
        if (str.equals("0") || str.equals("")) {
            return "0";
        }
        
        String binary = "";
        while (n != 0) {
            binary = String.valueOf(n % 2) + binary;
            n /= 2;
        }
        
        return binary;
    }
    
    private String parseFloat(String str) {
        double d = Double.parseDouble("0." + str);
        HashSet<Double> set = new HashSet<Double>();
        String binary = "";
        
        while (d > 0) {
            if (binary.length() > 32 || set.contains(d)) {
                return "ERROR";
            }
            set.add(d);
            d *= 2;
            if (d >= 1) {
                binary += "1";
                d -= 1;
            } else {
                binary += "0";
            }
        }
 
        return binary;
    }
}
