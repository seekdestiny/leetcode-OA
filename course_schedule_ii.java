// DFS
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
             for (int i = 0; i < numCourses; i++) {
                 result[i] = i;
             }
             
             return result;
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Stack<Integer> res = new Stack<Integer>();
        
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(i, visited, graph, res)) {
                return new int[0];
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.pop();
        }
        
        return result;
    }
    
    private boolean hasCycle(int i, int[] visited, Map<Integer, List<Integer>> graph, Stack<Integer> res) {
        visited[i] = 1;

        for (Integer v1 : graph.get(i)) {
            if (visited[v1] == 1) {
                return true;
            }
            
            if (visited[v1] == 0 && hasCycle(v1, visited, graph, res)) {
                return true;
            }
        }
        
        visited[i] = 2;
        res.push(i);
        return false;
    }
}
