/** very long code
 *  first run bfs to calculate distance, and trackback path
 *  then dfs from end point to start point to find all possible paths 
**/

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladder = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        
        wordList.add(beginWord);
        wordList.add(endWord);
        
        bfs(beginWord, endWord, map, distance, wordList);
        dfs(ladder, beginWord, endWord, map, distance, new ArrayList<String>());
        
        return ladder;
    }
    
    public void dfs(List<List<String>> ladder, String beginWord, String crt, Map<String, List<String>> map,
                    Map<String, Integer> distance, List<String> path) {
        path.add(crt);
        if (crt.equals(beginWord)) {
            Collections.reverse(path);
            ladder.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next: map.get(crt)) {
                if (distance.containsKey(next) && distance.get(next) + 1 == distance.get(crt)) {
                    dfs(ladder, beginWord, next, map, distance, path);   
                }
            }
        }
        
        path.remove(path.size() - 1);
    }
    
    public void bfs(String beginWord, String endWord, Map<String, List<String>> map, 
                    Map<String, Integer> distance, Set<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        
        for (String s : wordList) {
            map.put(s, new ArrayList<String>());
        }
        
        distance.put(beginWord, 0);
        
        while (!q.isEmpty()) {
            String crt = q.poll();
            for (String next: findNext(crt, wordList)) {
                map.get(next).add(crt);    
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }
    
    private List<String> findNext(String crt, Set<String> wordList) {
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == crt.charAt(i)) {
                    continue;
                }
                
                String next = replace(crt, ch, i);
                if (wordList.contains(next)) {
                    res.add(next);
                }
            }
        }
        
        return res;
    }
    
    private String replace(String crt, char ch, int i) {
        char[] cArray = crt.toCharArray();
        cArray[i] = ch;
        return new String(cArray);
    }
}
