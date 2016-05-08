/** bfs
 * level by level scan, once reach end, return number of scan steps
**/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        
        dict.add(start);
        dict.add(end);
        
        HashSet<String> record = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        
        record.add(start);
        q.add(start);
        
        int length = 1;
        while (!q.isEmpty()) {
            length++;
            
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.poll();
                
                for (String next : findNext(dict, current)) {
                    if (record.contains(next)) {
                        continue;
                    }
                    
                    if (end.equals(next)) {
                        return length;
                    }
                    
                    record.add(next);
                    q.add(next);
                }
            }
        }
        
        return 0;
    }
    
    private ArrayList<String> findNext(Set<String> dict, String current) {
        ArrayList<String> res = new ArrayList<String>();
        
        for (int i = 0; i < current.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == current.charAt(i)) {
                    continue;
                }
                
                String possible = replace(current, i, ch);
                if (dict.contains(possible)) {
                    res.add(possible);
                }
            }
        }
        
        return res;
    }
    
    private String replace(String current, int i, char ch) {
        char[] cArray = current.toCharArray();
        cArray[i] = ch;
        return new String(cArray);
    }
}
