//method 1: BFS
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);      
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        queue.add(0);
        set.add(0);
        
        int cnt = n;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            
            for (int item: graph.get(temp)) {
                if (!set.contains(item)) {
                    queue.add(item);
                    set.add(item);
                    graph.get(item).remove(temp);
                } else {
                    return false;
                }
            }
            cnt--;
        }
        
        return cnt == 0;
    }
}
///////////////////
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);      
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        queue.add(0);
        
        int cnt = n;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (set.contains(temp)) {
                return false;
            }
            
            set.add(temp);
            
            for (int item: graph.get(temp)) {
                if (!set.contains(item)) {
                    queue.add(item);
                }
            }
            cnt--;
        }
        
        return cnt == 0;
    }
}

//method2: dfs
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);      
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }
        
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
       
        return true;
    }
    
    private boolean dfs(int i, int prev, Map<Integer, Set<Integer>> graph, 
                        boolean[] visited) {
        if (visited[i]) {
            return false;
        }
        
        visited[i] = true;;
        
        for (int v : graph.get(i)) {
            if (v != prev && !dfs(v, i, graph, visited)) {
                return false;
            }
        }
        
        return true;
    }
}
