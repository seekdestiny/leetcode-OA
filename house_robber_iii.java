/** divide and conquer
 **/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class ResultType {
    int withRoot;
    int withoutRoot;
    
    public ResultType(int withRoot, int withoutRoot) {
        this.withRoot = withRoot;
        this.withoutRoot = withoutRoot;
    }
} 

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        ResultType res = helper(root);
        return Math.max(res.withRoot, res.withoutRoot);
    }
    
     private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int value1 = left.withoutRoot + right.withoutRoot + root.val;
        int value2 = Math.max(left.withoutRoot, left.withRoot) + 
                     Math.max(right.withoutRoot, right.withRoot);
                     
        return new ResultType(value1, value2);
    }
}
