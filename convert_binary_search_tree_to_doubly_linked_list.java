//recursive solution
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    private DoublyListNode dummy = new DoublyListNode(0);
    private DoublyListNode current = dummy;
     
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        helper(root);
        return dummy.next;
    }
    
    private void helper (TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(root.left);
        
        DoublyListNode newNode = new DoublyListNode(root.val);
        current.next = newNode;
        newNode.prev = current;
        current = current.next;
        
        helper(root.right);
    }
}

//non-recursive solution
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    private DoublyListNode dummy = new DoublyListNode(0);
    private DoublyListNode current = dummy;
     
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode current = dummy;
        // Write your code here
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode track = root;
        
        while (track != null || !stack.isEmpty()) {
            while (track != null) {
                stack.add(track);
                track = track.left;
            }            
            
            track = stack.pop();
            
            DoublyListNode newNode = new DoublyListNode(track.val);
            current.next = newNode;
            newNode.prev = current;
            current = current.next;
            
            track = track.right;
        }
        
        return dummy.next;
    }
}
