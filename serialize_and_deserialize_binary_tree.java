/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/** level order traversal
 * bfs
**/
 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        StringBuilder sb = new StringBuilder();
        
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            
            if (tmp == null) {
                sb.append("null,");
            } else {
                sb.append(String.valueOf(tmp.val) + ",");
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        
        String[] array = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        
        int index = 0;
        boolean isLeft = true;
        
        for (int val = 1; val < array.length; val++) {
            if (!array[val].equals("null")) {
                TreeNode current = new TreeNode(Integer.parseInt(array[val]));
                if (isLeft) {
                    list.get(index).left = current;
                } else {
                    list.get(index).right = current;
                }
                list.add(current);
            }
            
            if (!isLeft) {
                index++;
            }
            
            isLeft = !isLeft;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
