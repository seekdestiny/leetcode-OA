/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
 
/** BFS implementation
**/
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashMap<DirectedGraphNode, Integer> inDegree = new HashMap<DirectedGraphNode, Integer>();
        
        for (int i = 0; i < graph.size(); i++) {
            for (DirectedGraphNode neighbor: graph.get(i).neighbors) {
                if (!inDegree.containsKey(neighbor)) {
                    inDegree.put(neighbor, 1);
                } else {
                    inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                }
            }
        }
        
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
    
        for (int i = 0; i < graph.size(); i++) {
            if (!inDegree.containsKey(graph.get(i))) {
                q.add(graph.get(i));
                res.add(graph.get(i));
            }
        }
        
        while (!q.isEmpty()) {
            DirectedGraphNode temp = q.poll();
            for (DirectedGraphNode neighbor: temp.neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    q.add(neighbor);
                    res.add(neighbor);
                }
            }
        }
        
        return res;
    }
}
