/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
 /**
  * bfs 
  * first step: copy node and build map relation
  * copy neighbor
**/
 
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        int start = 0;
        while (start < nodes.size()) {
            UndirectedGraphNode temp = nodes.get(start++);
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    nodes.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        
        for (UndirectedGraphNode original : nodes) {
            for (UndirectedGraphNode neighbor : original.neighbors) {
                map.get(original).neighbors.add(map.get(neighbor));   
            }
        }
        
        return map.get(node);
    }
}
