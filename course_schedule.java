/** bfs
 * topological sorting
**/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int j = 0; j < numCourses; j++) {
            if (inDegree[j] == 0) {
                queue.offer(j);
            }
        }
        
        int count = numCourses;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer neighbor : graph.get(current)) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
            
            count--;    
        }
        
        return count == 0;
    }
}
