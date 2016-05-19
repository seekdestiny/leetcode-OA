public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) return true;
        if (pattern == null || str == null) return false;
        
        String[] array = str.split(" ");
        
        if (pattern.length() != array.length) return false;
        
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        
        for (int i = 0; i < pattern.length(); i++) {
            if (!map1.containsKey(pattern.charAt(i)) && !map2.containsKey(array[i])) {
                map1.put(pattern.charAt(i), array[i]);
                map2.put(array[i], pattern.charAt(i));
            } else if (map1.containsKey(pattern.charAt(i)) && map2.containsKey(array[i])) {
                if (!map1.get(pattern.charAt(i)).equals(array[i])) return false;
                if (map2.get(array[i]) != pattern.charAt(i)) return false;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
