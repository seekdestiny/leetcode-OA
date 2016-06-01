/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode tmp = root;
        TreeNode parent = dummy;
        
        //find target node and its parent
        while (tmp != null) {
            TreeNode prev = tmp;
            if (tmp.val < value) {
                parent = prev;
                tmp = tmp.right;
            } else if (tmp.val > value) {
                parent = prev;
                tmp = tmp.left;
            } else {
                break;
            }
        }
        
        //if target is not found
        if (tmp == null) return dummy.left;
        
        //if target's left child tree is empty
        if (tmp.left == null) {
            if (parent.left == tmp) parent.left = tmp.right;
            if (parent.right == tmp) parent.right = tmp.right;
        } else {
            //if target's left child tree is not empty
            TreeNode current = tmp.left; //will be right most node
            TreeNode prev = tmp;
            while (current.right != null) {
                prev = current;
                current = current.right;
            } //find right most node in left child tree
        
            //swap right most node with target node
            if (prev == tmp) {
                 prev.left = current.left;
            } else {
                 prev.right = current.left;
            }
            
            if (parent.left == tmp) parent.left = current;
            if (parent.right == tmp) parent.right = current;
            
            current.left = tmp.left;
            current.right = tmp.right;
        }
        
        return dummy.left;
    }
}
