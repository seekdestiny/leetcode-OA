//use decreasing stack

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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        for (int i = 0; i < A.length; i++) {
            TreeNode current = new TreeNode(A[i]);
            
            TreeNode temp = null;
            while (!stack.isEmpty() && current.val > stack.peek().val) {
                temp = stack.pop();
                if (!stack.isEmpty() && stack.peek().val < current.val) {
                    stack.peek().right = temp;
                }
            }
            
            current.left = temp;
            stack.push(current);
        }
        
        //connect root to right child, right child' right chile all the way
        //down to right leaf
        while (stack.size() > 1) {
            TreeNode temp = stack.pop();
            stack.peek().right = temp;
        }
        
        return stack.pop();
    }
}
